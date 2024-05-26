package com.example.BookService.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookService.models.Book;
import com.example.BookService.service.BookService;

@RestController
@RequestMapping("/api/v1")
public class BookController {
	@Autowired
	private BookService service;
	// get all books
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return service.getAllBooks();
	}
	// add book
	@PostMapping("/book")
	public Book addBook(@RequestBody Book book) {
		return service.addBook(book);
	}
	// delete book by id
	@DeleteMapping("book/{id}")
	public String deleteBookById(@PathVariable Integer id) {
		service.deleteBookById(id);
		return "delete book successfully!";
	}
	// get book by id
	@GetMapping("/book/{id}")
	public Book getBookById(@PathVariable Integer id) {
		return service.getBookById(id);
	}
	// update book by id
	@PatchMapping("/book/{id}")
	public Book updateBook(@PathVariable Integer id, @RequestBody  Book book) {
		return service.updateBook(id, book);
	}
	
}
