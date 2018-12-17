package spring.beans.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.beans.annotation.TestObject;
import spring.beans.annotation.service.UserService;

@Controller
public class UserController {
	/**
	 * 虽然UserController已经交给IOC容器来进行管理了，但是UserController得Bean中，没有建立与UserService属性的依赖关系
	 */
	//去IOC容器中去寻找有没有类型兼容的bean，
	//@Autowired
	private UserService userService;
	
	
	//如果testObject没有Component注解，即IOC容器中没有这个bean的话，会抛出异常，如果指定这个bean不是必须存在，注意：
	@Autowired(required=false)
	private TestObject testObject;
	
	//放到setter方法上也是可以的
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void execute() {
		System.out.println("UserController execute..");
		System.out.println(testObject);
		
		//没有建立与UserService属性的依赖关系，会报空指针异常
		userService.add();
	}
}
