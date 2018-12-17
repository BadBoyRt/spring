package spring.beans.generic.di;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {

	/**
	 * 会被子类继承
	 * 
	 * 即UserService子类和UserRepository子类的依赖关系，不需要再去@autowired了
	 */
	@Autowired
	protected BaseRepository<T> repository;
	
	public void add() {
		System.out.println("BaseRepository add..");
		System.out.println(repository);
	}
}
