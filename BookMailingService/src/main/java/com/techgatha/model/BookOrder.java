package com.techgatha.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
public class BookOrder {

	@Id
	private int orderno;
	private String email;
	private String bookid;
	private String datetime;
	public BookOrder() {
		// TODO Auto-generated constructor stub
	}
	public BookOrder(int orderno, String email, String bookid, String datetime) {
		super();
		this.orderno = orderno;
		this.email = email;
		this.bookid = bookid;
		this.datetime = datetime;
	}
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "BookOrder [orderno=" + orderno + ", email=" + email + ", bookid=" + bookid + ", datetime=" + datetime
				+ "]";
	}
	
}

