package spring.beans.annotation;

import org.springframework.stereotype.Component;

@Component()
public class TestObject {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TestObject [name=" + name + "]";
	}

	public TestObject() {
		super();
	}
	
	
	
}
