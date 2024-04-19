package com.example.CartService.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class BookDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String author;
	public String publisher;
	private Double unitPrice;
	private String image;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Temporal(TemporalType.DATE)
	private Date publishingYear;
	private Boolean available;
	// Integer categoryId;
	private Integer quantity;
	private String des;
	private Double discount;
	private Integer viewCount;
	private Boolean special;
	private CategoryDTO category;
	private List<OrderDetailDTO> orderDetails;
	public BookDTO() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", name=" + name + ", author=" + author + ", publisher=" + publisher
				+ ", unitPrice=" + unitPrice + ", image=" + image + ", publishingYear=" + publishingYear
				+ ", available=" + available + ", quantity=" + quantity + ", des=" + des + ", discount=" + discount
				+ ", viewCount=" + viewCount + ", special=" + special + ", category=" + category + ", orderDetails="
				+ orderDetails + "]";
	}
	public BookDTO(Integer id, String name, String author, String publisher, Double unitPrice, String image,
			Date publishingYear, Boolean available, Integer quantity, String des, Double discount, Integer viewCount,
			Boolean special, CategoryDTO category, List<OrderDetailDTO> orderDetails) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.unitPrice = unitPrice;
		this.image = image;
		this.publishingYear = publishingYear;
		this.available = available;
		this.quantity = quantity;
		this.des = des;
		this.discount = discount;
		this.viewCount = viewCount;
		this.special = special;
		this.category = category;
		this.orderDetails = orderDetails;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Date getPublishingYear() {
		return publishingYear;
	}
	public void setPublishingYear(Date publishingYear) {
		this.publishingYear = publishingYear;
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
	public Integer getViewCount() {
		return viewCount;
	}
	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}
	public Boolean getSpecial() {
		return special;
	}
	public void setSpecial(Boolean special) {
		this.special = special;
	}
	public CategoryDTO getCategory() {
		return category;
	}
	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
	public List<OrderDetailDTO> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetailDTO> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
}
