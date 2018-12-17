package spring.beans.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository(value="userRepositoty")//自定义IOC容器管理的bean的名字
public class UserRepositoryImpl implements UserRepository {

	@Override
	public void save() {
		System.out.println("UserRepositoryImpl save...");

	}

}
