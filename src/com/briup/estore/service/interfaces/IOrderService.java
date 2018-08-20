package com.briup.estore.service.interfaces;

import java.util.Collection;
import java.util.List;

import com.briup.estore.common.bean.Book;
import com.briup.estore.common.bean.Customer;
import com.briup.estore.common.bean.Line;
import com.briup.estore.common.bean.Order;
import com.briup.estore.common.exception.BookException;
import com.briup.estore.common.exception.EstoreCommonException;
import com.github.pagehelper.PageInfo;

/**
 * 订单信息Service
 * 
 * @author ASUS
 * @date 2018-7-30
 *
 */
public interface IOrderService {
	
	//提交订单信息并入库
	void confirmOrder(Customer customer,Order order,Collection<Line> lines) throws EstoreCommonException,BookException;
	
	//删除订单信息
	void deleteOrder(Integer id) throws EstoreCommonException;
	
	//通过顾客Id查询订单信息
	PageInfo<Order> findOrderByCustomerId(Integer id, int page, int rows) throws EstoreCommonException;
	
	//通过订单Id查询订单项信息
	Order findByOrderId(Integer orderid) throws EstoreCommonException;
	
	//通过订单Id查询订单信息
	Order findOrderWithLineAndBookById(Integer id) throws EstoreCommonException;
	
	//修改订单状态
	void updateStatus(Order order)throws EstoreCommonException;
}
