package com.example.CartService.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class OrderDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String phone;
	private String address;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date orderDate;
	private Double total;
	private Integer status;
	private String des;
	private List<OrderDetailDTO> orders;
	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", phone=" + phone + ", address=" + address + ", orderDate=" + orderDate
				+ ", total=" + total + ", status=" + status + ", des=" + des + ", orders=" + orders + "]";
	}
	public OrderDTO(Integer id, String phone, String address, Date orderDate, Double total, Integer status, String des,
			List<OrderDetailDTO> orders) {
		super();
		this.id = id;
		this.phone = phone;
		this.address = address;
		this.orderDate = orderDate;
		this.total = total;
		this.status = status;
		this.des = des;
		this.orders = orders;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public List<OrderDetailDTO> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderDetailDTO> orders) {
		this.orders = orders;
	}
	
}
