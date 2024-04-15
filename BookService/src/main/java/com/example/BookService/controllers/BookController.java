package com.example.BookService.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BookController {
	@GetMapping("/books")
	public String getAllBooks() {
		return "books";
	}
}
