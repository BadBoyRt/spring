package spring.beans.generic.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		/**
		 * SPRING4.0新特性：泛型依赖注入
		 * 
		 * BaseService.java
		 */
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/beans/generic/di/beans-generic-di.xml");
		
		UserService userService = (UserService) ctx.getBean("userService");
		System.out.println(userService);
		
		userService.add();//UserRepository
	}
}
