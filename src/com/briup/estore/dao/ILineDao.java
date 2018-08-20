package com.briup.estore.dao;

import com.briup.estore.common.bean.Book;
import com.briup.estore.common.bean.Line;
import com.briup.estore.common.bean.Order;


/**
 * 订单项Dao
 * 
 * @author danmo
 * @date2018-7-30
 *
 */
public interface ILineDao  {
	
	/**
	 * 根据订单id删除订单项
	 * @param oid
	 */
	public void deleteLine(int oid);
	
	/**
	 * 保存订单项
	 * @param book
	 * @param order
	 * @param line
	 */
	public void saveOrderDetail(Book book,Order order,Line line);
	
	/**
	 * 通过OrderId查看订单项信息
	 * @param id
	 * @return
	 */
	public Order findByOrderId(int id);
}
