package spring.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_account", schema="rongtao")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String username;
	private int balabce;//余额
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getBalabce() {
		return balabce;
	}
	public void setBalabce(int balabce) {
		this.balabce = balabce;
	}

	
}
