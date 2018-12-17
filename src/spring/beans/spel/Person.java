package spring.beans.spel;

import java.util.List;
import java.util.Map;

import spring.beans.cycle.Car;

/**
 * 
 * @author rongtao
 * create date:2018年12月5日 下午3:07:34
 */
public class Person {
	private String name;
	private Car car;
	
	private String city;//引用address的city属性
	
	//根据car的price确定
	//car.price>=300000为金领，否则白领
	private String info;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", car=" + car + ", city=" + city + ", info=" + info + "]";
	}

}
