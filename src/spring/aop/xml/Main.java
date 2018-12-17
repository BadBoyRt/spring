package spring.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		//1.初始化ioc容器
		ApplicationContext ctx  = new ClassPathXmlApplicationContext("spring/aop/xml/aop-xml.xml");
		//2.从ioc容器中获取bean实例
		ArithmeticCalculator bean = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		//3.使用bean
		int add = bean.add(2, 3);
		System.out.println("result : " + add);
		//发生异常的后置通知
		System.out.println("result : " + bean.div(10, 1));
	}

}
