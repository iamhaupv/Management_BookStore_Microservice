package com.example.BookService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookService.models.Book;
import com.example.BookService.service.BookService;

@RestController
@RequestMapping("/api/v1")
public class BookController {
	@Autowired
	private BookService service;
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return service.getAllBooks();
	}
}
