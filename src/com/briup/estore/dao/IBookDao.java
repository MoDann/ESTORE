package com.briup.estore.dao;

import java.util.List;
import java.util.Map;

import com.briup.estore.common.bean.Book;
import com.briup.estore.common.bean.Type;

/**
 * 书籍Dao
 * 
 * @author danmo
 * @date 2018-7-30
 */
public interface IBookDao  {
	
	/**
	 * 查询所有书籍信息
	 * 
	 * @return List<Book>
	 */
	public List<Book> queryAll();
	
	/**
	 * 根据书籍id查询书籍信息
	 * 
	 * @param id
	 * @return Book
	 */
	public Book queryById(Integer id);
	
	/**
	 * 根据书籍id查询书籍类型信息
	 * 
	 * @param id
	 * @return Type
	 */
	public Type queryByBookId(Integer id);
	
	/**
	 * 根据书籍名称查询书籍信息
	 * 
	 * @param name
	 * @return Type
	 */
	public Book queryByName(String name);
	
	/**
	 * 根据类型查询相关书籍信息
	 * 
	 * @param type
	 * @return List<Book>
	 */
	public List<Book> queryByType(Type type);
	
	/**
	 * 根据书籍Id修改书籍库存
	 *  
	 * @param num
	 * @param id
	 */
	public void updateNum(Integer num,Integer id);
	
	/**
	 * 根据书籍Id修改书籍状态（库存为0时，商品下架，状态为0）
	 * @param id
	 */
	public void updateStatus(Book book);
	
	/**
	 * 根据条件查询
	 * @param map
	 * @return
	 */
	public List<Book> selectBook(Map<String, Object> map);
	
	
	/**
	 * 查询所有的类别信息
	 * 
	 * @return
	 */
	public List<Type> findType();
	
	Type getTypeByName(String name);
}
