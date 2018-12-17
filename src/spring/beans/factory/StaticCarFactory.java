package spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方法：直接调用某一个类的静态方法就可以返回bean的实例
 */
public class StaticCarFactory {
	
	private static Map<String, Car> cars = new HashMap<String, Car>();
	
	/**
	 * 静态块中对cars初始化
	 */
	static{
		cars.put("Audi", new Car("Audi Q5"));
		cars.put("BenChi", new Car("BenChi X1"));
	}

	//静态工厂方法。
	public static Car getCar(String name) {
		return cars.get(name);
	}
}
