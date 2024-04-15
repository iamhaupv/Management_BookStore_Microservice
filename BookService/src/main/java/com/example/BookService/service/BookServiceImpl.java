package com.example.BookService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookService.models.Book;
import com.example.BookService.repositories.BookRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository repository;

	@Override
	public List<Book> getAllBooks() {
		return repository.findAll();
	}

	@Override
	public Book getBookById(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public Book addBook(Book book) {
		return repository.save(book);
	}

	@Override
	public String deleteBookById(Integer id) {
		repository.deleteById(id);
		return "delete book successfully!";
	}

	@Override
	public Book updateBook(Integer id, Book bookNew) {
		Book bookOld = repository.findById(id).orElse(null);
		if (bookOld != null) {
			if (bookNew.getName() != null && !bookNew.getName().isEmpty()) {
				bookOld.setName(bookNew.getName());
				bookOld.setAuthor(bookNew.getAuthor());
				bookOld.setPublisher(bookNew.getPublisher());
				bookOld.setPublishingYear(bookNew.getPublishingYear());
				return repository.save(bookOld);
			}
		}
		return null;
	}

}
