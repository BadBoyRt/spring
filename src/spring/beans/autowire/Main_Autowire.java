package spring.beans.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main_Autowire {

	public static void main(String[] args) {
		//获取自动装配的配置文件（获取IOC容器）
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-autowire.xml");
		
		Student s = (Student) ctx.getBean("student");//手动装配方式
		System.out.println(s);
		
		Student s1 = (Student) ctx.getBean("autowire_byName");//自动装配方式byName
		System.out.println(s1);
		//Student s2 = (Student) ctx.getBean("autowire_byType");//自动装配方式byType
		//System.out.println(s2);
		
		
		
	}
}
