package spring.beans.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.beans.annotation.controller.UserController;
import spring.beans.annotation.repository.UserRepositoryImpl;
import spring.beans.annotation.service.UserService;


public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/beans/annotation/beans-annotation.xml");
		
		//TestObject testObject = (TestObject) ctx.getBean("testObject");//bean的id如果没有在注解上指定value属性，默认第一个字母小写。
		//System.out.println(testObject);
		
		//UserRepositoryImpl repositoryImpl = (UserRepositoryImpl) ctx.getBean("userRepositoty");
		//System.out.println(repositoryImpl);
		
		UserController userController = (UserController) ctx.getBean("userController");
		System.out.println(userController);
		userController.execute();
		
		//UserService userService = (UserService) ctx.getBean("userService");
		//System.out.println(userService);
	}
	
	
}
