package spring.beans.factory;

public class Car {

	public Car() {
		super();
		System.out.println("调用Car's Construcor 初始化Car...");
	}
	
	
	public Car(String name) {
		super();
		this.name = name;
		System.out.println("in car's cunstructor");
	}


	private String name;
	
	public void setName(String name) {
		this.name = name;
		System.out.println("调用Setter方法 对Car的属性赋值");
	}
	
	//名字叫什么无所谓，和bean对应上就行
	public void init2() {
		System.out.println("init...");
	}
	
	public void destroy() {
		System.out.println("destroy...");
	}

	@Override
	public String toString() {
		return "Car [name=" + name + "]";
	}

	
}
