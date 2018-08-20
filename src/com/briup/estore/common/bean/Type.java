package com.briup.estore.common.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 类别实体类
 * 
 * @author danmo
 * @date 2018-7-30
 */
public class Type implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键 id
	 */
	private Integer id;
	
	/**
	 * 类别名称
	 */
	private String name;
	
	/**
	 * 与书本的关联信息 一对多
	 */
	private List<Book> books;
	
	
	public Type() {
	}
	
	
	public Type(String name) {

		this.name = name;
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + ", books=" + books + "]";
	}
	
	
	
	
}
