package com.example.CartService.dto;

import java.io.Serializable;
import java.util.List;

public class CategoryDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private List<BookDTO> bookDTOs;
	public CategoryDTO() {
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
	public List<BookDTO> getBookDTOs() {
		return bookDTOs;
	}
	public void setBookDTOs(List<BookDTO> bookDTOs) {
		this.bookDTOs = bookDTOs;
	}
	public CategoryDTO(Integer id, String name, List<BookDTO> bookDTOs) {
		super();
		this.id = id;
		this.name = name;
		this.bookDTOs = bookDTOs;
	}
	@Override
	public String toString() {
		return "CategoryDTO [id=" + id + ", name=" + name + ", bookDTOs=" + bookDTOs + "]";
	}
}
