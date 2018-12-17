package spring.beans;

public class HelloWord {

	private String name;

	public void setName2(String name) {
		System.out.println("in Spring.setter...");
		this.name = name;
	}
	
	public void hello() {
		System.out.println("Hello: "+name);
	}
	//无参构造器
	public HelloWord() {
		System.out.println("in Constructor...");
	}
	
	public HelloWord(String str) {
		System.out.println("in Constructor...");
	}
	
}
