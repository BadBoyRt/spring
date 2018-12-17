package spring.beans.relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.beans.autowire.Student;
import spring.beans.spel.Address;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-relation.xml");
		
		Address address = (Address) ctx.getBean("address");
		System.out.println(address);
		
		address = (Address) ctx.getBean("address3");
		System.out.println(address);
		
		Student student  = (Student) ctx.getBean("student");
		System.out.println(student);
		
	}

}
