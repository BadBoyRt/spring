package spring.tx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cashier")
public class CashierImpl implements Cashier {

	@Autowired
	private BookShopService bookShopService;
	
	
	/**
	 * 一个事务方法，去调用另外一个事务方法。
	 * 	事务是如何传播的？
	 */
	//一个人要买多本书
	@Transactional
	@Override
	public void checkout(String username, List<String> isbns) {
		for(String isbn : isbns) {
			bookShopService.purcharse(username, isbn);
		}

	}

}
