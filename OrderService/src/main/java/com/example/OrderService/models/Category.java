package com.example.OrderService.models;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private List<Book> books;
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(Integer id, String name, List<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.books = books;
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
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", books=" + books + "]";
	}
}
