package spring.beans.cycle;

public class Car {

	public Car() {
		super();
		System.out.println("调用Car's Construcor 初始化Car...");
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
