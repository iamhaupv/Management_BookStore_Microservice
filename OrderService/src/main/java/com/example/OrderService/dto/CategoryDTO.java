package com.example.OrderService.dto;

import java.io.Serializable;
import java.util.List;

public class CategoryDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private List<BookDTO> books;
	public CategoryDTO() {
		// TODO Auto-generated constructor stub
	}
	public CategoryDTO(Integer id, String name, List<BookDTO> books) {
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
	public List<BookDTO> getBooks() {
		return books;
	}
	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", books=" + books + "]";
	}
}
