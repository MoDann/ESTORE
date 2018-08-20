 package com.briup.estore.web.controller;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.estore.common.bean.Book;
import com.briup.estore.common.bean.Cart;
import com.briup.estore.common.bean.Customer;
import com.briup.estore.common.bean.Line;
import com.briup.estore.common.bean.ShoppingCar;
import com.briup.estore.common.exception.EstoreCommonException;
import com.briup.estore.common.util.ResponseResult;
import com.briup.estore.service.interfaces.IBookService;
import com.briup.estore.service.interfaces.ICartService;


/**
 * 购物车Controller
 * @author danmo
 * @date 2018-7-31
 *
 */
@Controller
public class CartController {
	
	@Autowired
	private ICartService cartService;
	
	@Autowired
	private IBookService bookService;
	
	@RequestMapping("/addProduct.action")
	public String addCart(Integer bookid,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		ShoppingCar car = (ShoppingCar) session.getAttribute("cart");
		try {
			Book book = bookService.findById(bookid);
			Line line = new Line(bookid, book);
			line.setNum(1);
			car.add(line);
			session.setAttribute("cart", car);
			session.setAttribute("cost", car.getCost());
			return "redirect:/shopcart.action";
		} catch (EstoreCommonException e) {
			request.setAttribute("msg", "加入购物车失败："+e.getMessage());
			e.printStackTrace();
			return "/index";
		}
	}
	
	@RequestMapping("/updateCart/{bookid}/{num}")
	@ResponseBody
	public Object updateCart(@PathVariable Integer bookid,@PathVariable Integer num,
			HttpSession session) {
		
		ShoppingCar car = (ShoppingCar) session.getAttribute("cart");
		try {
			Book book = bookService.findById(bookid);
			Line line = new Line(bookid, book);
			line.setNum(num);
			car.update(line);
			session.setAttribute("cart", car);
			session.setAttribute("cost", car.getCost());
			return ResponseResult.build(200, "success",car.getCost());
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			return ResponseResult.build(500, "faile");
		}
	}
	

	@RequestMapping("/removeProduct.action")
	public String removeCart(Integer bookid, HttpSession session) {
		
		ShoppingCar car = (ShoppingCar) session.getAttribute("cart");
		car.delete(bookid);
		session.setAttribute("cost", "");
		return "redirect:shopcart.action";
	}
	
	@RequestMapping("/removeAllProduct.action")
	public String removeAllCart(HttpSession session) {
		
		ShoppingCar car = (ShoppingCar) session.getAttribute("cart");
		car.clear();
		session.setAttribute("cost", "");
		return "redirect:shopcart.action";
	}
	
	@RequestMapping("/logout.action")
	public String saveCart(HttpSession session) {
		
		ShoppingCar cart = (ShoppingCar) session.getAttribute("cart");
		Customer customer = (Customer) session.getAttribute("customer");
		Map<Integer, Line> lines = cart.getLines();
		Cart cart2 = new Cart();
		
		for (Entry<Integer, Line> entry:lines.entrySet()) {
			Integer bid = entry.getKey();
			Line line = entry.getValue();
			Book book;
			try {
				book = bookService.findById(bid);
				cart2.setBook(book);
				Integer num = line.getNum();
				Double price = book.getPrice();
				cart2.setCustomer(customer);
				cart2.setNum(num);
				cart2.setPrice(price);
				cartService.saveCart(cart2);			
			}catch(EstoreCommonException e){
				e.printStackTrace();
				session.setAttribute("msg", "保存失败："+e.getMessage());
			}
		}
		return "redirect:/logout";
	}
		
}
