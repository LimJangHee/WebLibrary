package biz.rental;

import java.util.Date;

public class RentalVO {
	
	int rental_id;
	int isbn;
	String name;
	String user_id;
	Date rent;
	Date receive;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	public Date getRent() {
		return rent;
	}
	public void setRent(Date rent) {
		this.rent = rent;
	}
	
	
	public int getRental_id() {
		return rental_id;
	}
	public void setRental_id(int rental_id) {
		this.rental_id = rental_id;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getReceive() {
		return receive;
	}
	public void setReceive(Date receive) {
		this.receive = receive;
	}
	
	
}
