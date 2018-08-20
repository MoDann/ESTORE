package com.briup.estore.dao;

import com.briup.estore.common.bean.Customer;

/**
 * 顾客Dao
 * 
 * @author danmo
 * @date 2018-7-30
 *
 */
public interface ICustomerDao  {
	
	/**
	 * 根据用户名查询顾客信息
	 * @param name
	 * @return
	 */
	public Customer findByName(String name);
	
	/**
	 * 保存顾客信息
	 * @param customer
	 */
	public void saveCustomer(Customer customer);
	
	/**
	 * 根据顾客id查询顾客信息
	 * @param id
	 * @return
	 */
	public Customer findById(int id);
	
	/**
	 * 更新顾客信息
	 * @param customer
	 */
	public void updateCustomer(Customer customer);
}
