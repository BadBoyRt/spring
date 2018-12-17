package spring.beans.annotation.repository;

import org.springframework.stereotype.Repository;

//IOC容器中有两个UserRepository类型的bean  impl   impl2
//而在UserService中，装配的是UserRepository类型
//NoUniqueBeanDefinitionException
@Repository
public class UserRepositoryImpl2 implements UserRepository {

	@Override
	public void save() {
		System.out.println("UserRepositoryImpl2 save...");

	}

}
