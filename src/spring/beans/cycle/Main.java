package spring.beans.cycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Main {
	
	public static void main(String[] args) {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cycle.xml");
		
		//ApplicationContext的子接口有关闭IOC容器的方法
		//1.Constructor,2.setter,3.init
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cycle.xml");
		
		Car car  = (Car) ctx.getBean("car");
		System.out.println(car);
		
		//关闭IOC容器
		ctx.close();//4.destroy
	}

}
