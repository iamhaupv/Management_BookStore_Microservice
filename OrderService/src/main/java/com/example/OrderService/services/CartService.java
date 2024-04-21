package com.example.OrderService.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.OrderService.dto.BookDTO;
@Service
public interface CartService {
	public void addBookToCart(Integer id);

	public int getCount();

	public double getTotal();

	public Collection<BookDTO> getItems();

	public void removeBookFromCart(Integer id);
}
