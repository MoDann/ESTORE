package com.briup.estore.common.bean;

import java.io.Serializable;
/**
 * Book实体类
 * 
 * @author Danmo
 * @date 2018-7-30
 * */
public class Book implements Serializable {
	
	/** 序列号，方便实现反序列化 */
	private static final long serialVersionUID = 1L;
	
	/** 主键 id */
	private Integer id;
	
	/**
	 * 书名
	 */
	private String name;
	
	/**
	 * 价格
	 */
	private Double price;
	
	/**
	 * 描述
	 */
	private String description;
	
	/**
	 * 数量（库存）
	 */
	private Integer num;
	
	/**
	 * 状态（上下架）1-正常，0-下架
	 */
	private Integer status;
	
	/**
	 * 图片信息
	 */
	private String pic;
	
	/**
	 * 作者
	 */
	private String author;
	
	/**
	 * 与类型关联关系   多对一
	 */	
	private Type type;
	
	public Book(){
		
	}

	public Book(String name, Double price, String description, Integer num,
			Integer status, String pic,String author, Type type) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.num = num;
		this.status = status;
		this.pic = pic;
		this.author=author;
		this.type = type;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price
				+ ", description=" + description + ", num=" + num + ", status="
				+ status + ", pic=" + pic + ", author=" + author + ", type="
				+ type + "]";
	}

	
}
