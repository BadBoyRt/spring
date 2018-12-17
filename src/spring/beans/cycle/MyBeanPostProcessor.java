package spring.beans.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Before   Initialization: "+bean+", "+beanName);
		//可以返回原生、修改、甚至新建的bean。
		//通常可以进行一些逻辑处理，返回bean
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("After  Initialization: "+bean+", "+beanName);
		Car car = new Car();
		car.setName("new Bean");
		return car;
	}

}
