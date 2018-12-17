package spring.beans;

import java.util.Properties;

public class DataSource {
	
	private Properties properties;//Properties是HashTable的子类，HashTable是Map的一个实现类
	
	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "DataSource [properties=" + properties + "]";
	}

}
