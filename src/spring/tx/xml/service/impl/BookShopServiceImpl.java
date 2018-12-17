package spring.tx.xml.service.impl;

import spring.tx.xml.BookShopDao;
import spring.tx.xml.service.BookShopService;

//@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	//@Autowired
	private BookShopDao bookShopDao;
	
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}
	
	//添加事务注解
	/**
	 * 1.使用propagation 制定事务的传播行为。即当前事务方法被另外一个事务方法调用时
	 * 	默认取值REQUIRED：使用调用方法的事务
	 * REQUIRES_NEW：使用自己的事务。调用的方法的事务被挂起。
	 * 2.isolation:指定事务的隔离级别。最常用的是READ_COMMITTED（读已提交）
	 * 3.默认情况下，spring的声明式事务，对所有的运行时异常进行回滚。也可以通过对应 的属性设置。通常情况下并不进行设置。
	 * 4.使用readOnly指定是否为只读：表示这个事务只读取数据，但不更新数据。这样可以帮助数据库引擎优化事务。
	 * 5.timeout:指定强制回滚之前，事务可以占用的时间
	 */
	/*@Transactional(propagation=Propagation.REQUIRES_NEW, 
			isolation=Isolation.READ_COMMITTED, 
			readOnly=false, 
			timeout=3)*/
	@Override
	public void purcharse(String username, String isbn) {
		
		//Thread.sleep(5000);
		
		// 1.获取书单价
		int price  = bookShopDao.findBookPriceByIsbn(isbn);
		
		//2.更新书库存
		bookShopDao.updateBookStock(isbn);
		
		//3.更新余额
		bookShopDao.updateUserAccount(username, price);
		
	}

}
