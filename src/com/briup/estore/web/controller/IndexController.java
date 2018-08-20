package com.briup.estore.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.briup.estore.common.bean.Book;
import com.briup.estore.common.bean.Type;
import com.briup.estore.common.exception.EstoreCommonException;
import com.briup.estore.service.interfaces.IBookService;
import com.github.pagehelper.PageInfo;

/**
 * 首页Controller
 * @author danmo
 * @date 2018-7-31
 */
@Controller
public class IndexController {

	@Autowired
	private IBookService bookService;
	
	@RequestMapping(value={"/","/index"})
	public String showIndex(@RequestParam(value="page",defaultValue="1") Integer page,
			HttpServletRequest request) {
		try {
			PageInfo<Book> pageInfo = bookService.findAllBookWithPage(page, 5);
			List<Type> types = bookService.findType();
			ServletContext context = request.getServletContext();
			context.setAttribute("pageinfo", pageInfo);
			context.setAttribute("types", types);
		} catch (EstoreCommonException e) {
			request.setAttribute("msg", "查询失败："+e.getMessage());
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/productDetail.action")
	public String bookDetail(Integer bookid,HttpServletRequest request) {
		
		try {
			Type type = bookService.findByBookId(bookid);
			System.out.println(type);
			List<Book> books = type.getBooks();
			for (Book book : books) {
				System.out.println(book);
				request.setAttribute("bookDetail", book);
			}
			request.setAttribute("type", type);
			return "productDetail";
		} catch (EstoreCommonException e) {
			request.setAttribute("msg", "书本信息为空："+e.getMessage());
			e.printStackTrace();
		}
		return "index";
	}
	
	
	@RequestMapping("/select.action")
	public String showSelect(String bookname, String author, String type, String price,
			@RequestParam(value="page",defaultValue="1") Integer page,HttpServletRequest request) {
		
		Map<String,Object> map = new HashMap<>();
		HttpSession session = request.getSession();
		if (type!=null) {
	    	if (!type.equals("0")) {
	    		int tid = Integer.parseInt(type);
		    	map.put("tid", tid);
		    	session.setAttribute("type", type);
	    	}
	    	
		}
		if (price != null) {
			if (!price.equals("0") ) {
				String[] split = price.split("-");
				int price1 = Integer.parseInt(split[0]);
				int price2 = Integer.parseInt(split[1]);
				map.put("price1", price1);
				map.put("price2", price2);
				session.setAttribute("price", price);
			}
			
		}
		if (StringUtils.isNotBlank(bookname)) {
			map.put("name", "%" + bookname + "%");
			session.setAttribute("bookname", bookname);
		}
		if (StringUtils.isNotBlank(author)) {
			map.put("author", author);
			session.setAttribute("author", author);
		}
		
		try {
			PageInfo<Book> pageInfo = bookService.selectBookByEx(map, page, 5);
			request .setAttribute("pageinfo", pageInfo);
			return "search";
		} catch (EstoreCommonException e) {
			request .setAttribute("msg", "查询失败："+e.getMessage());
			return "index";
		}    
	
	}
}
