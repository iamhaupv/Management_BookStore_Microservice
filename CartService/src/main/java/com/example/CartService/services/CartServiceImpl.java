package com.example.CartService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CartService.models.Cart;
import com.example.CartService.repositories.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	@Override
	public List<Cart> all() {
		return cartRepository.findAll();
	}
	
}
