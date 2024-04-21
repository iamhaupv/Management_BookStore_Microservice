package com.example.BookService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.BookService.models.Book;
import com.example.BookService.repositories.BookRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository repository;
	private final RedisTemplate<String, List<Book>> redisTemplate;

	@Autowired
	public BookServiceImpl(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	@Cacheable(value = "books")
	public List<Book> getAllBooks() {
		return repository.findAll();
	}

	@Override
	@Cacheable(value = "books", key = "#id")
	public Book getBookById(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	@CachePut(value = "books")
	public Book addBook(Book book) {
		return repository.save(book);
	}

	@Override
	@CacheEvict(value = "books", allEntries = true)
	public String deleteBookById(Integer id) {
		repository.deleteById(id);
		return "delete book successfully!";
	}

	@Override
	@CachePut(value = "books")
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
