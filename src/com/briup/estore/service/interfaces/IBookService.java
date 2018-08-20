package com.briup.estore.service.interfaces;

import java.util.List;
import java.util.Map;

import com.briup.estore.common.bean.Book;
import com.briup.estore.common.bean.Type;
import com.briup.estore.common.exception.EstoreCommonException;
import com.github.pagehelper.PageInfo;

/**
 * 书籍Service
 * 
 * @author ASUS
 * @date 2018-7-30
 */
public interface IBookService {
	
	//获取所有商品信息
	List<Book> getAllBooks() throws EstoreCommonException;
	
	//根据Id获取商品信息
	Book findById(Integer id) throws EstoreCommonException;
	
	//根据商品Id获取其对应的类型信息
	Type findByBookId(Integer id) throws EstoreCommonException;
	
	
	/**
	 * 分页信息：
	 * 	当前页面
	 *  总记录数
	 *  ...
	 * @throws EstoreCommonException
	 */
	//首页分页
	PageInfo<Book> findAllBookWithPage(int page,int rows) throws EstoreCommonException;
	
	//根据条件查询结果分页
	PageInfo<Book> selectBookByEx(Map<String, Object> map, int page, int rows) throws EstoreCommonException;
	
	//获取所有的商品类型信息
	public List<Type> findType()throws EstoreCommonException;

	Type getTypeByName(String name) throws EstoreCommonException;
	
}
