package com.example.OrderService.services;

import java.util.Collection;

import com.example.OrderService.dto.BookDTO;

public interface CartService {
	public void addBookToCart(Integer id);

	public int getCount();

	public double getTotal();

	public Collection<BookDTO> getItems();

	public void removeFromCart(Integer id);
}
