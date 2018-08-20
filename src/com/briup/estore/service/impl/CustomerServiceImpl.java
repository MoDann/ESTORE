package com.briup.estore.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.estore.common.bean.Customer;
import com.briup.estore.common.exception.EstoreCommonException;
import com.briup.estore.common.util.UtilMD5;
import com.briup.estore.dao.ICustomerDao;
import com.briup.estore.service.interfaces.ICustomerService;

/**
 * 顾客信息Service
 * 
 * @author danmo
 * @date 2018-7-30
 *
 */
@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerDao customerDao;

	@Override
	public void register(Customer customer) throws EstoreCommonException {

		if (customer == null) {
			throw EstoreCommonException.getException(401);
		}
		customer.setPassword(UtilMD5.getMd5(customer.getPassword()));
		//保存用户信息
		customerDao.saveCustomer(customer);
	}

	@Override
	public Customer login(String name, String password)
			throws EstoreCommonException {
		
		if (StringUtils.isBlank(name) && StringUtils.isBlank(password)) {
			throw EstoreCommonException.getException(401);
		}
		Customer customer = customerDao.findByName(name);
		System.out.println(customer);
		String md5 = UtilMD5.getMd5(password);
		System.out.println(md5);
		if (customer == null || !customer.getPassword().equals(md5) ) {
			throw EstoreCommonException.getException(402);
		}
		return customer;
	}

	@Override
	public Customer findCustomerByName(String name)
			throws EstoreCommonException {
		
		if (StringUtils.isBlank(name)) {
			throw EstoreCommonException.getException(401);
		}
		Customer customer = customerDao.findByName(name);
		return customer;
	}
	
	@Override
	public void updateCustomer(Customer customer) throws EstoreCommonException {
		
		if (customer == null) {
			throw EstoreCommonException.getException(401);
		}
		customer.setPassword(UtilMD5.getMd5(customer.getPassword()));
		customerDao.updateCustomer(customer);
	}


}
