package spring.jdbc;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class JDBCTest1 {
	
	private ApplicationContext ctx = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("spring/jdbc/spring-jdbc.xml");
	}
	

	@Test
	void testDataSource() {
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
