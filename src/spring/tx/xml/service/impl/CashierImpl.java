package spring.tx.xml.service.impl;

import java.util.List;

import spring.tx.xml.service.BookShopService;
import spring.tx.xml.service.Cashier;

//@Service("cashier")
public class CashierImpl implements Cashier {

	//@Autowired
	private BookShopService bookShopService;
	
	public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}
	
	/**
	 * 一个事务方法，去调用另外一个事务方法。
	 * 	事务是如何传播的？
	 */
	//一个人要买多本书
	//@Transactional
	@Override
	public void checkout(String username, List<String> isbns) {
		for(String isbn : isbns) {
			bookShopService.purcharse(username, isbn);
		}

	}

}
