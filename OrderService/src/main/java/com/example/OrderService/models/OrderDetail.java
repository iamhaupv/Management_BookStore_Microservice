package com.example.OrderService.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "order_details")
public class OrderDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "orderDetail_id")
	private Integer id;
	private Double unitPrice;
	private Integer quantity;
	private Double discount;
	private int bookId;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(Integer id, Double unitPrice, Integer quantity, Double discount, int bookId) {
		super();
		this.id = id;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.discount = discount;
		this.bookId = bookId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", discount="
				+ discount + ", bookId=" + bookId + "]";
	}
}
