package com.briup.estore.dao;


import java.util.List;

import com.briup.estore.common.bean.Order;


public interface IOrderDao  {
	
	/**
	 * 保存订单信息
	 * @param order
	 */
	void saveOrder(Order order);
	
	/**
	 * 根据id查询订单信息
	 * @param id
	 * @return
	 */
	Order findOrderById(Integer id);
	
	/**
	 * 根据id查询order与book以及line
	 * @param id
	 * @return
	 */
	Order findOrderWithLineAndBookById(Integer id);
	
	/**
	 * 根据id删除订单信息
	 * @param id
	 */
	void deleteOrder(int id);
	
	/**
	 * 通过CustomerId查询订单信息
	 * @param id
	 * @return 
	 */
	List<Order> findOrderByCustomerId(Integer id);
	
	/**
	 * 修改订单状态
	 * @param order
	 */
	void updateStatus(Order order);
	
}
