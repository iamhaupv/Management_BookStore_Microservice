package com.example.CartService.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "carts")
public class Cart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private Integer id;
	private Integer bookId;
	private String bookName;
	private Integer quantity;
	private Double total;
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Cart(Integer id, Integer bookId, String bookName, Integer quantity, Double total) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.bookName = bookName;
		this.quantity = quantity;
		this.total = total;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", bookId=" + bookId + ", bookName=" + bookName + ", quantity=" + quantity
				+ ", total=" + total + "]";
	}
	
}
