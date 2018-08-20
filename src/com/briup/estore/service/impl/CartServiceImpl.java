package com.briup.estore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.estore.common.bean.Cart;
import com.briup.estore.common.exception.EstoreCommonException;
import com.briup.estore.dao.ICartDao;
import com.briup.estore.service.interfaces.ICartService;

/**
 * 购物车Service
 * 
 * @author danmo
 * @date 2018-8-1
 *
 */
@Service
public class CartServiceImpl implements ICartService {
	
	@Autowired
	private ICartDao cartDao;

	@Override
	public List<Cart> findCartsByCid(Integer cid) throws EstoreCommonException {
		if (cid.equals("")) {
			throw EstoreCommonException.getException(401);
		}
		List<Cart> carts = cartDao.findCartsByCid(cid);
		if (carts != null && carts.size() > 0) {
			return carts;
		}
		throw EstoreCommonException.getException(404);
	}

	@Override
	public void saveCart(Cart cart) throws EstoreCommonException {
		
		if (cart == null) {
			throw EstoreCommonException.getException(401);
		}
		Cart cart2 = cartDao.findByCidAndBid(cart.getCustomer().getId(), cart.getBook().getId());
		if(cart2 != null){
			cartDao.updateCart(cart);
		}
		cartDao.saveCart(cart);
	}

}
