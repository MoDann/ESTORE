package com.briup.estore.common.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * 顾客类
 * 
 * @author danmo
 * @date 2018-7-30
 */
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键id
	 */
	private Integer id;
	
	/**
	 * 用户名
	 */
	private String name;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 邮编
	 */
	private String zip;
	
	/**
	 * 地址
	 */
	private String address;
	
	/**
	 * 城市
	 */
	private String city;
	
	/**
	 * 手机号
	 */
	private String phone;
	
	/**
	 * email
	 */
	private String email;
	
	/**
	 * 订单关联关系 - 一对多
	 */
	private Set<Order> orders = new HashSet<>();
	
	public Customer(){
		
	}
	
	public Customer(String name, String password, String address,
			String city, String zip, String phone, String email) {
		this.name = name;
		this.password = password;
		this.zip = zip;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.email = email;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password="
				+ password + ", zip=" + zip + ", address=" + address
				+ ", city=" + city + ", phone=" + phone + ", email=" + email
				+ ", orders=" + orders + "]";
	}
	
	
}
