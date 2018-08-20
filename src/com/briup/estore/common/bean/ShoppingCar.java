package com.briup.estore.common.bean;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 * 购物车 （订单项）
 * 
 * @author danmo
 * @date 2018-7-30
 */
public class ShoppingCar {
	
	// key 商品id value 订单项（商品，数量）
	private Map<Integer, Line> map = new HashMap<Integer, Line>();
	
	/**
	 * 向购物车中添加产品
	 * 先判断购物车中有没有该产品的订单项目，如果有，在数量上做改变，
	 * 如果没有向map中添加
	 * @param line
	 */
	public void add(Line line){
		if(map.containsKey(line.getBook().getId())){
			Line oldline = map.get(line.getBook().getId());
			oldline.setNum(oldline.getNum()+1);
		}else{
			line.setNum(1);
			map.put(line.getBook().getId(), line);
			System.out.println(line.getBook().getId());
			System.out.println(line);
		}
	}
	
	/**
	 * 删除订单
	 * @param bookId
	 */
	public void delete(Integer bookId){
		map.remove(bookId);
	}
	
	/**
	 * 获取价格
	 * @return double
	 */
	public double getCost(){
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> iter = keySet.iterator();
		double cost = 0.0;
		while(iter.hasNext()){
			Integer key = iter.next();
			Line value = map.get(key);
			Integer num = value.getNum();
			double price = value.getBook().getPrice();
			double lineCost = num*price;
			cost += lineCost;
		}
		return cost;
	}
	
	/**
	 * 获取购物车中所有订单项
	 * List<Line>
	 */
	public Map<Integer, Line> getLines(){
		return map;
	}
	
	
	public void setMap(Map<Integer, Line> map) {
		this.map = map;
	}
	/**
	 * 清空购物车
	 */
	public void clear(){
		map.clear();
	}
	
	/**
	 * 更新购物车
	 * 
	 * @param line 订单项信息
	 */
	public void update(Line line) {
		Line oldline = map.get(line.getBook().getId());
		oldline.setNum(line.getNum());
	}
	
}
