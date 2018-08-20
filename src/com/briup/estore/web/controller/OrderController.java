package com.briup.estore.web.controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.briup.estore.common.bean.Book;
import com.briup.estore.common.bean.Customer;
import com.briup.estore.common.bean.Line;
import com.briup.estore.common.bean.Order;
import com.briup.estore.common.bean.ShoppingCar;
import com.briup.estore.common.exception.BookException;
import com.briup.estore.common.exception.EstoreCommonException;
import com.briup.estore.service.interfaces.IBookService;
import com.briup.estore.service.interfaces.IOrderService;
import com.github.pagehelper.PageInfo;


/**
 * 订单信息Controller
 * 
 * @author danmo
 * @date 2018-8-01
 *
 */
@Controller
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IBookService bookService;
	
	@SuppressWarnings("static-access")
	@RequestMapping("/saveOrder.action")	
	public String saveOrder(HttpServletRequest request,Integer payway) {
		
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		Double cost = (Double) session.getAttribute("cost");
			
		ShoppingCar car = (ShoppingCar) session.getAttribute("cart");
		Map<Integer, Line> lines = car.getLines();
		Collection<Line> lineCollection = lines.values();
		
		String payway1 = null;
		if (payway== 1) {
			payway1 = "邮局汇款";
		}else if (payway == 2) {
			payway1 = "货到付款";
		}else if (payway == 3) {
			payway1 = "银行转账";
		}else if (payway == 4) {
			payway1 = "线上付款";
		}
		
		Order order = new Order(cost,new Date(),0,payway1);
	
		try {
			try {
				orderService.confirmOrder(customer, order, lineCollection);
				//清空购物车
				ShoppingCar car2 = new ShoppingCar();
				session.setAttribute("cart", car2);
				session.setAttribute("cost", null);
				return "redirect:/order.action";
			} catch (BookException e) {	
				e.printStackTrace();
				int id = Integer.parseInt(e.getMessage());
				Book book = new Book();
				try {
					book = bookService.findById(id);
				} catch (EstoreCommonException e1) {
					e.printStackTrace();
				}
				String name = book.getName();
				session.setAttribute("massage",name+"  库存不足");
				return "redirect:/confirmOrder";
			}
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			session.setAttribute("massage", "购物车为空："+e.getMessage(401));
			return "redirect:/confirmOrder";
		}
	}
	
	@RequestMapping("/order.action")
	public String showOrder(HttpSession session,@RequestParam(value="page",defaultValue="1") Integer page) {
		
		Customer customer = (Customer) session.getAttribute("customer");
		try {
			PageInfo<Order> orders = orderService.findOrderByCustomerId(customer.getId(),page,5);
			session.setAttribute("orders", orders);
		} catch (EstoreCommonException e) {
			session.setAttribute("msg", "查询失败："+e.getMessage());
			e.printStackTrace();
		}
		return "order";
	}
	
	@RequestMapping("/removeOrder.action")
	public String removeOrder(Integer orderid,HttpSession session,@RequestParam(value="page",defaultValue="1") Integer page) {
		
		Customer customer = (Customer) session.getAttribute("customer");
		try {
			orderService.deleteOrder(orderid);
			PageInfo<Order> orders = orderService.findOrderByCustomerId(customer.getId(),page,5);
			session.setAttribute("orders", orders);
		} catch (EstoreCommonException e) {
			session.setAttribute("msg", "删除失败："+e.getMessage());
			e.printStackTrace();
		}
		return "order";
	}

	@RequestMapping("/orderInfo.action")
	public String orderDetail(Integer orderid, HttpSession session) {
		
		try {
			Order order = orderService.findByOrderId(orderid);
			session.setAttribute("orderinfo", order);
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", "查询失败："+e.getMessage());
		}
		return "orderinfo";
	}
	
	/**
	 * 付款
	 * @param orderid
	 * @param session
	 * @return
	 */
	@RequestMapping("/payway")
	public String showPayway(Integer orderid,HttpSession session){
		try {
			Order order = orderService.findByOrderId(orderid);
			session.setAttribute("order", order);
			return "payway";
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", "支付失败："+e.getMessage());
			return "order";
		}
		
	}
}
