package com.briup.estore.service.interfaces;


import java.util.List;

import com.briup.estore.common.bean.Cart;
import com.briup.estore.common.exception.EstoreCommonException;

/**
 * 购物车管理Service
 * 
 * @author ASUS
 * @date 2018-7-30
 */
public interface ICartService {
	
	//根据顾客Id获取其的购物车信息
	public  List<Cart> findCartsByCid(Integer cid) throws EstoreCommonException;
	
	//保存购物车
	void saveCart(Cart cart)throws EstoreCommonException;

}
