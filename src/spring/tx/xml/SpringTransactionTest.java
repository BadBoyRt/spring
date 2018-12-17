package spring.tx.xml;


import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.tx.xml.service.BookShopService;
import spring.tx.xml.service.Cashier;

class SpringTransactionTest {
	
	private ApplicationContext ctx = null;
	public BookShopDao bookShopDao = null;
	private BookShopService bookShopService = null;
	private Cashier cashier = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("spring/tx/xml/spring-tx-xml.xml");
		bookShopDao = (BookShopDao) ctx.getBean("bookShopDao");
		bookShopService = (BookShopService) ctx.getBean("bookShopService");
		cashier = (Cashier) ctx.getBean("cashier");
	}
	
	@Test
	public void testTransactionalPropagation() {
		cashier.checkout("liyi", Arrays.asList("1001", "1002"));
	}
	
	@Test
	public void testBookShopService() {
		bookShopService.purcharse("liyi", "1001");
	}
	

	@Test
	public void testUpdateUserAccount() {
		bookShopDao.updateUserAccount("liyi", 500);
	}
	
	@Test
	public void testBookShopDaoUpdateBookStock() {
		bookShopDao.updateBookStock("1001");
	}
	
	@Test
	public void testFindPriceByIsbn() {
		System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
	}

}
