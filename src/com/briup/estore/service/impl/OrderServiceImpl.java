package com.briup.estore.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.estore.common.bean.Book;
import com.briup.estore.common.bean.Customer;
import com.briup.estore.common.bean.Line;
import com.briup.estore.common.bean.Order;
import com.briup.estore.common.exception.BookException;
import com.briup.estore.common.exception.EstoreCommonException;
import com.briup.estore.dao.IBookDao;
import com.briup.estore.dao.ICartDao;
import com.briup.estore.dao.ILineDao;
import com.briup.estore.dao.IOrderDao;
import com.briup.estore.service.interfaces.IOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 订单信息service
 * @author danmo
 * @date 2018-8-1
 *
 */

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderDao orderDao;
	
	@Autowired
	private ILineDao lineDao;
	
	@Autowired
	private IBookDao bookDao;
	
	@Autowired
	private ICartDao cartDao;
	
	@Override
	public void confirmOrder(Customer customer, Order order,
			Collection<Line> lines) throws EstoreCommonException, BookException {
		
		if (order != null && customer !=null) {
			order.setCustomer(customer);
			if (lines != null && lines.size() > 0) {
				orderDao.saveOrder(order);
				for (Line line : lines) {
					Book book = line.getBook();
					System.out.println(book.getNum() +":"+ line.getNum());
					if (book.getNum() >= line.getNum()) {
						int num = book.getNum() - line.getNum();
						if (num == 0) {
							book.setStatus(0);
							bookDao.updateStatus(book);
						}
						book.setNum(num);
						bookDao.updateNum(book.getNum(),book.getId());
						lineDao.saveOrderDetail(book, order,line);
						cartDao.deleteCartByCid(customer.getId());
					}else {
						throw new BookException(String.valueOf(book.getId()));
					}
				}
			}else {
				throw EstoreCommonException.getException(401);
			}
		}else {
			throw EstoreCommonException.getException(401);
		}
	}

	@Override
	public void deleteOrder(Integer id) throws EstoreCommonException {

		Order order = orderDao.findOrderById(id);
		if (order != null) {
			lineDao.deleteLine(id);
			orderDao.deleteOrder(id);
		}else {
			throw EstoreCommonException.getException(404);
		}
		
	}

	@Override
	public PageInfo<Order> findOrderByCustomerId(Integer id, int page, int rows)
			throws EstoreCommonException {
		
		PageHelper.startPage(page, rows);
		if (id.equals("")) {
			throw EstoreCommonException.getException(401);
		}
		List<Order> orders = orderDao.findOrderByCustomerId(id);
		if (orders.size()>0) {
			return new PageInfo<Order>(orders);
		}else {
			throw EstoreCommonException.getException(404);
		}
	}

	/**
	 * 在订单项中根据orderId查询
	 */
	@Override
	public Order findByOrderId(Integer orderid) throws EstoreCommonException {
		
		Order order = lineDao.findByOrderId(orderid);
		if (order!=null) {
			return order;
		}else {
			throw EstoreCommonException.getException(404);
		}

	}

	@Override
	public void updateStatus(Order order) throws EstoreCommonException {
		
		if (order == null) {
			throw EstoreCommonException.getException(401);
		}
		orderDao.updateStatus(order);
		
	}

	@Override
	public Order findOrderWithLineAndBookById(Integer id) throws EstoreCommonException {
		
		Order order = orderDao.findOrderWithLineAndBookById(id);
		if (order == null) {
			throw EstoreCommonException.getException(404);
		}
		return order;
	}

}
