package spring.tx;

public interface BookShopDao {

	//根据书号获取单价
	int findBookPriceByIsbn(String isbn);
	
	//更新书的库存:使书号对应的库存减一
	void updateBookStock(String isbn);
	
	//更新用户的账户余额;username.balance-price
	void updateUserAccount(String username, int price);
}
