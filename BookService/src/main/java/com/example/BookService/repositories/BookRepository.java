package com.example.BookService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookService.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
