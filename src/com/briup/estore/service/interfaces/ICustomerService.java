package com.briup.estore.service.interfaces;

import com.briup.estore.common.bean.Customer;
import com.briup.estore.common.exception.EstoreCommonException;

/**
 * 客户信息管理Service
 * 
 * @author ASUS
 * @date 2018-7-30
 *
 */
public interface ICustomerService {
	
	//注册用户信息
	void register(Customer customer) throws EstoreCommonException;
	
	//根据用户名查询用户信息
	Customer findCustomerByName(String name) throws EstoreCommonException;
	
	//用户登录
	Customer login(String name,String password) throws EstoreCommonException;
	
	//更新顾客信息
	void updateCustomer(Customer customer) throws EstoreCommonException;
}
