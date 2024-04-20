package com.example.OrderService.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class BookDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String author;
	public String publisher;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Temporal(TemporalType.DATE)
	private Date publishingYear;
	private Double unitPrice;
	private String image;
	private Boolean available;
	private Integer quantity;
	private String des;
	private Double discount;
	public BookDTO() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", name=" + name + ", author=" + author + ", publisher=" + publisher
				+ ", publishingYear=" + publishingYear + ", unitPrice=" + unitPrice + ", image=" + image
				+ ", available=" + available + ", quantity=" + quantity + ", des=" + des + ", discount=" + discount
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPublishingYear() {
		return publishingYear;
	}
	public void setPublishingYear(Date publishingYear) {
		this.publishingYear = publishingYear;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public BookDTO(int id, String name, String author, String publisher, Date publishingYear, Double unitPrice,
			String image, Boolean available, Integer quantity, String des, Double discount) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.publishingYear = publishingYear;
		this.unitPrice = unitPrice;
		this.image = image;
		this.available = available;
		this.quantity = quantity;
		this.des = des;
		this.discount = discount;
	}
	
}
