package spring.beans.autowire;

import java.util.List;

import spring.beans.spel.Address;

public class Student {

	private	String name;
	private int age;
	private Address address;
	private List<Book> books;
	private Phone phone;
	
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", address=" + address + ", books=" + books + ", phone="
				+ phone + "]";
	}
	
	
	
	
}
