package com.example.CartService.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class BookDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Double unitPrice;
	private String image;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date productDate;
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
	public Date getProductDate() {
		return productDate;
	}
	public void setProductDate(Date productDate) {
		this.productDate = productDate;
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
	public BookDTO(Integer id, String name, Double unitPrice, String image, Date productDate, Boolean available,
			Integer quantity, String des, Double discount, Integer viewCount, Boolean special, CategoryDTO category,
			List<OrderDetailDTO> orderDetails) {
		super();
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
		this.image = image;
		this.productDate = productDate;
		this.available = available;
		this.quantity = quantity;
		this.des = des;
		this.discount = discount;
		this.viewCount = viewCount;
		this.special = special;
		this.category = category;
		this.orderDetails = orderDetails;
	}
	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", name=" + name + ", unitPrice=" + unitPrice + ", image=" + image
				+ ", productDate=" + productDate + ", available=" + available + ", quantity=" + quantity + ", des="
				+ des + ", discount=" + discount + ", viewCount=" + viewCount + ", special=" + special + ", category="
				+ category + ", orderDetails=" + orderDetails + "]";
	}
}
