package spring.beans.autowire;

public class Phone {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Phone [name=" + name + "]";
	}
	
}
