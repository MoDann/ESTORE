package com.briup.estore.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.briup.estore.service.interfaces.ICustomerService;

/**
 * 用户Controller
 * 
 * @author danmo
 * @data 2018-7-30
 */

@Controller
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private ICartService cartService;
	
	@Autowired
	private IBookService bookService;
	
	@RequestMapping("/register.action")
	public String register(Customer customer,HttpSession session) {
		System.out.println(customer);
		try {
			customerService.register(customer);
			session.setAttribute("msg", "注册成功,请登录");
			return "redirect:/login";
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", "注册失败："+e.getMessage());
			return "/register";
		}
		
	}
	
	@RequestMapping("/checkUser.action")
	@ResponseBody
	public Object checkUser(String name) {
		System.out.println(name);
		Customer customer = null;
		try {
			customer = customerService.findCustomerByName(name);
		} catch (EstoreCommonException e) {
			e.printStackTrace();
		}
		System.out.println(customer);
		return customer;
	}
	
	@RequestMapping("/checkUserName/{name}")
	@ResponseBody
	public Object checkUserName(@PathVariable String name) {
		System.out.println(name);
		try {
			Customer customer = customerService.findCustomerByName(name);
			if (customer == null) {
				return ResponseResult.ok();
			}
			return ResponseResult.build(500, "faile");
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			return ResponseResult.build(500, "faile");
		}
	}
	
	@RequestMapping("/login.action")
	public String login(String name,String password,HttpSession session) {
		System.out.println(name+":"+password);
		ShoppingCar car = new ShoppingCar();
		Map<Integer,Line> map = new HashMap<>();
		try {
			Customer customer = customerService.login(name, password);
			System.out.println(customer);
			session.setAttribute("customer", customer);
			session.setAttribute("username", name);
			//查询该用户的购物车信息
			try {
				List<Cart> carts = cartService.findCartsByCid(customer.getId());
				for (Cart cart : carts) {
					Integer id = cart.getBook().getId();
					Book book = bookService.findById(id);
					Line line = new Line(id, cart.getNum(), book);
					map.put(id, line);
					car.setMap(map);
					session.setAttribute("cart", car);
				}
				session.setAttribute("cost", car.getCost());
			} catch (Exception e) {
			//	session.setAttribute("msg", "获取购物车失败："+e.getMessage());
				e.printStackTrace();
				session.setAttribute("cart", car);
			}
			return "redirect:/index";
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", "登录失败："+e.getMessage());
			return "login";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/index";
	}
	
	@RequestMapping("/modify.action")
	public String showUserInfo(Customer customer,HttpServletRequest request) {
		try {
			customerService.updateCustomer(customer);
			request.setAttribute("msg", "修改成功");
		} catch (EstoreCommonException e) {
			request.setAttribute("msg", "修改失败:"+e.getMessage());
			e.printStackTrace();
		}
		return "redirect:/login";
		
	}

}
