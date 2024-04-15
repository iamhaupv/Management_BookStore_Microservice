package com.example.BookService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.BookService.models.Book;

@Service
public interface BookService {
	public List<Book> getAllBooks();
	public Book getBookById(Integer id);
	public Book addBook(Book book);
	public String deleteBookById(Integer id);
	public Book updateBook(Integer id, Book book);
}
