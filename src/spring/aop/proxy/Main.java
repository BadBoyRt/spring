package spring.aop.proxy;

public class Main {

	public static void main(String[] args) {
		/*ArithmeticCalculator arithmeticCalculator = null;
		arithmeticCalculator = new ArithmeticCalculatorImpl();
		int add = arithmeticCalculator.add(1, 2);
		int sub = arithmeticCalculator.sub(2, 1);
		int div = arithmeticCalculator.div(2, 2);
		int mul = arithmeticCalculator.mul(4, 2);*/
		
		//目标对象是实现类
		ArithmeticCalculator target = new ArithmeticCalculatorImpl();
		
		//使用动态代理
		ArithmeticCalculator proxy = new TestProxy(target).getProxy();
		proxy.add(1, 2);
		proxy.sub(2, 1);
		proxy.mul(2, 2);
		proxy.div(8, 8);
	}
}
