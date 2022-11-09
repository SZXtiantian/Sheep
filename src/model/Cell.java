package model;


/**
 * 
* @Description 单元格对象---->两种状态0：没有牌 1：有牌
* @author TimTim Email:754595995@qq.com
* @version 
* @date 2022年11月4日下午8:01:54
*
 */
public class Cell {
	private Integer state = 0;
	private Brand brand;
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}	
}
