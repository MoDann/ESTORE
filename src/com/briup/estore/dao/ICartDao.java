package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.common.bean.Cart;

/**
 * 购物车Dao
 * 
 * @author danmo
 * @date 2018-7-30
 *
 */
public interface ICartDao {

	/**
	 * 根据顾客id 查询所有的购物车信息
	 * 
	 * @param cid
	 * @return
	 */
	public List<Cart> findCartsByCid(Integer cid);
	
	/**
	 * 根据顾客id与书籍id查询对应的购物车信息
	 * @param cid
	 * @param bid
	 * @return
	 */
	public Cart findByCidAndBid(Integer cid,Integer bid);
	
	/**
	 * 保存购物车信息
	 * @param cart
	 */
	public void saveCart(Cart cart);
	
	/**
	 * 更新购物车信息
	 * @param cart
	 */
	void updateCart(Cart cart);
	
	/**
	 * 根据顾客id清空购物车信息
	 * @param cid
	 */
	void deleteCartByCid(Integer cid);
}
