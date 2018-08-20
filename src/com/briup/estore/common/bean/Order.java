package com.briup.estore.common.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 订单实体类
 * 
 * @author danmo
 * @date 2018-7-30
 */
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键id
	 */
	private Integer id;
	/**
	 * 价钱（总价）
	 */
	private Double cost;
	
	/**
	 * 创建日期
	 */
	private Date orderDate;
	
	/**
	 * 关联关系 - 一对多 : 对应多个订单项
	 * */
	
	private List<Line> lines;
	
	/**
	 * 关联关系 - 多对一 : 对应一个顾客
	 * */
	private Customer customer;
	
	/**
	 * 订单状态（0-未付款，1-已付款，-1-已完成）
	 */
	private Integer status;
	
	/**
	 * 展示状态
	 */
	private String stt;
	
	/**
	 * 付款方式
	 */
	private String payway;
	
	public Order(){
		
	}
	public Order(Integer id, Double cost, Date orderDate) {
		this.id = id;
		this.cost = cost;
		this.orderDate = orderDate;
	}
	
	
	public Order(Double cost, Date orderDate, Integer status, String payway) {
		super();
		this.cost = cost;
		this.orderDate = orderDate;
		this.status = status;
		this.payway = payway;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public List<Line> getLines() {
		return lines;
	}
	public void setLines(List<Line> lines) {
		this.lines = lines;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getPayway() {
		return payway;
	}
	public void setPayway(String payway) {
		this.payway = payway;
	}
	
	
	
	public String getStt() {
		return stt;
	}
	public void setStt(String stt) {
		this.stt = stt;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", cost=" + cost + ", orderDate="
				+ orderDate + ", lines=" + lines + ", customer=" + customer
				+ ", status=" + status + ", payway=" + payway + "]";
	}
	
	
	
	
	
}
