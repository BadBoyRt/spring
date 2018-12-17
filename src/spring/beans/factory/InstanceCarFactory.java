package spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

//实例工厂方法:实例工厂的方法。需要先实例工厂本身，再调用工厂的实例方法返回bean的实例。
public class InstanceCarFactory {
	
	private Map<String, Car> cars = null;
	

	public InstanceCarFactory() {
		System.out.println("in factory");
		cars = new HashMap<String, Car>();
		cars.put("Audi", new Car("Audi Q5"));
		cars.put("BenChi", new Car("BenChi X1"));
	}

	//
	public Car getCar(String name) {
		return cars.get(name);
	}
}
