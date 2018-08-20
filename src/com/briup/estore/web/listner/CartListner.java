package com.briup.estore.web.listner;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;

import com.briup.estore.common.bean.Book;
import com.briup.estore.common.bean.Cart;
import com.briup.estore.common.bean.Customer;
import com.briup.estore.common.bean.Line;
import com.briup.estore.common.bean.ShoppingCar;
import com.briup.estore.common.exception.EstoreCommonException;
import com.briup.estore.service.interfaces.IBookService;
import com.briup.estore.service.interfaces.ICartService;

@WebListener
public class CartListner implements HttpSessionListener{

	@Autowired
	private ICartService cartService;
	
	@Autowired
	private IBookService bookService;
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
			
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = (HttpSession) se;
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
			} catch (EstoreCommonException e) {
				e.getMessage();
			}
		}
		
	}

}
