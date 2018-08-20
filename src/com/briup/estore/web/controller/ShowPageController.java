package com.briup.estore.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 显示页面Controller
 * 
 * @author ASUS
 * @date 2018-7-31
 */
@Controller
public class ShowPageController {

	@RequestMapping("/register")
	public String showRegister() {
		return "register";
	}
	
	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/shopcart.action")
	public String showShopCart() {
		return "shopcart";
	}
	
	@RequestMapping("/userinfo")
	public String showUserInfo() {
		return "user/userinfo";
		
	}
	
	@RequestMapping("/confirmOrder")
	public String showConfirmOrder() {
		return "user/confirmOrder";
	}
	
	
	@RequestMapping("/error")
	public String showError(){
		return "error";
	}
	
}
