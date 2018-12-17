package spring.beans.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import spring.beans.annotation.repository.UserRepository;

@Service
public class UserService {
	//关联关系
	//IOC容器中有两个UserRepository类型的bean  impl   impl2
	/**
	 * 两种解决方式，
	 * 1。声明bean时，名字和IOC容器装配的bean名字一致
	 * 2.可以指定装配哪个	userRepositoryImpl2
	 */
	//而在UserService中，装配的是UserRepository类型
	//NoUniqueBeanDefinitionException
	
	private UserRepository userRepository;
	
	
	/**
	 * 注解位置：
	 * 1.加到private UserRepository userRepository上
	 * 
	 * 2.放到setter方法上
	 * 
	 * 3.放到setter方法的参数前@Qualifier("userRepositoryImpl2")			Spring	MVC常有此种写法
	 */
	
	@Autowired
	//@Qualifier("userRepositoryImpl2")
	public void setUserRepository(@Qualifier("userRepositoryImpl2")UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void add() {
		System.out.println("UserService add...");
		userRepository.save();
	}
}
