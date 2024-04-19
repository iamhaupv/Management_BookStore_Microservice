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
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date publishingYear;
	public BookDTO() {
		// TODO Auto-generated constructor stub
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
	public BookDTO(int id, String name, String author, String publisher, Date publishingYear) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.publishingYear = publishingYear;
	}
	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", name=" + name + ", author=" + author + ", publisher=" + publisher
				+ ", publishingYear=" + publishingYear + "]";
	}
}
