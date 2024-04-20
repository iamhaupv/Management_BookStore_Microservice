package com.example.CartService.dto;

import java.io.Serializable;

public class OrderDetailDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Double unitPrice;
	private Integer quantity;
	private Double discount;
	private int bookId;
	private OrderDTO order;
	public OrderDetailDTO() {
		// TODO Auto-generated constructor stub
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
	public OrderDTO getOrder() {
		return order;
	}
	public void setOrder(OrderDTO order) {
		this.order = order;
	}
	public OrderDetailDTO(Integer id, Double unitPrice, Integer quantity, Double discount, int bookId, OrderDTO order) {
		super();
		this.id = id;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.discount = discount;
		this.bookId = bookId;
		this.order = order;
	}
	@Override
	public String toString() {
		return "OrderDetailDTO [id=" + id + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", discount="
				+ discount + ", bookId=" + bookId + ", order=" + order + "]";
	}
}
