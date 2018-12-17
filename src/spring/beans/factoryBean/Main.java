package spring.beans.factoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.beans.autowire.Student;
import spring.beans.spel.Address;

public class Main {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/beans/factoryBean/beans-factorybean.xml");
		
		Car car = (Car) ctx.getBean("car");
		System.out.println(car);
		
		
	}
}
