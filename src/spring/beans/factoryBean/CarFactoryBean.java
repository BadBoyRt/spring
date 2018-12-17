package spring.beans.factoryBean;

import org.springframework.beans.factory.FactoryBean;
//自定义FactoryBean需要实现Spring.FactoryBean
public class CarFactoryBean implements FactoryBean<Car> {
	
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Car getObject() throws Exception {
		return new Car(name);
	}

	/**
	 * 返回bean的类型
	 */
	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	/**
	 * 是否是单例
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

}
