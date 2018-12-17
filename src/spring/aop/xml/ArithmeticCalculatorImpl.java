package spring.aop.xml;

import org.springframework.stereotype.Component;
//交给spring的IOC容器来管理,value是自定义ioc容器中bean的名字
//@Component(value="arithmeticCalculator")
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		return a-b;
	}

	@Override
	public int mul(int a, int b) {
		return a*b;
	}

	@Override
	public int div(int a, int b) {
		return a/b;
	}

}
