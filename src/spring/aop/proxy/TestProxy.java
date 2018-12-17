package spring.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;


/**
 * 使用动态代理
 * 	
 * 	模拟日志记录
 * 		实现每次调用方法，输出日志功能。
 * 
 */
public class TestProxy {
	//要代理的对象、目标对象
	private ArithmeticCalculator target;
	
	//构造器,吧要代理的对象传进来哦
	TestProxy(ArithmeticCalculator target){
		this.target = target;
	}
	
	public ArithmeticCalculator getProxy() {
		ArithmeticCalculator proxy = null;
		//正常对象是直接new出来的jvm有默认的类加载器。而现在对象是凭空代理出来的，需要告诉代理对象由哪一个类加载器负责加载
		ClassLoader loader = target.getClass().getClassLoader();
		//代理对象的类型，即其中有哪些方法。
		Class[] interfaces = new Class[] { ArithmeticCalculator.class };
		//当调用代理对象其中的方法时，该执行代码（业务逻辑）
		InvocationHandler h = new InvocationHandler() {
			/**
			 * proxy:正在返回的那个代理对象，一般情况下，在invoke方法中都不使用该对象
			 * 
			 * method：正在被调用的方法。
			 * 
			 * args：调用方法时传入的参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName();
				//日志记录
				System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
				//调用目标方法
				Object result = null;
				try {
					//前置通知
					result = method.invoke(target, args);
					
					//返回通知：可以访问到方法的返回值
				} catch (Exception e) {
					e.printStackTrace();
					/**
					 * 异常通知：可以访问到在目标方法出现异常时会执行的代码。可以访问到异常对象；
					 * 	且可以指定出现特定异常时才执行的代码Exception ex、NullPointException ex...
					 */
				}
				
				//后置通知：因为方法可能出现异常，所以访问不到方法的返回值
				System.out.println("The method " + methodName + " end with " + result);
				return result;
			}
		};
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;
	}
	
}
