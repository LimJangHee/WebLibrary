package biz.book;

import java.util.Date;

public class BookVO {
	
	int isbn;
	String name;
	String writer;
	String publisher;
	Date receive;
	Boolean rentable;
	
//	public BookVO() {
//		rentable = true;
//	}
	
	public Boolean getRentable() {
		return rentable;
	}
	public void setRentable(Boolean rentable) {
		this.rentable = rentable;
	}
	public Date getReceive() {
		return receive;
	}
	public void setReceive(Date receive) {
		this.receive = receive;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		return "BookVO [isbn=" + isbn + ", name=" + name + ", writer=" + writer + ", publisher=" + publisher
				+ ", receive=" + receive + "]";
	}

}
