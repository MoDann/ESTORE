package com.briup.estore.common.bean;

import java.io.Serializable;


/**
 * 购物车实体类
 * 
 * @author danmo
 * @date 2018-7-30
 */
public class Cart implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键id
	 */
	private Integer id;
	
	/**
	 * 数量
	 */
	private Integer num;
	
	/**
	 * 价格
	 */
	private Double price;
	
	/**
	 * 顾客信息  多对一
	 */
	private Customer customer;
	
	/**
	 * 书籍信息 多对一
	 */
	private Book book;
	
	public Cart() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", num=" + num +  ", price=" + price +", customer=" + customer
				+ ", book=" + book + "]";
	}
	
	

}
