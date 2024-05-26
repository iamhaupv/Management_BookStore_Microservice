package com.example.CartService.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.CartService.models.Cart;

@Service
public interface CartService {
	public List<Cart> all();
}
