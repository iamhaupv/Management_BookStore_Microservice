package com.example.OrderService.controllers;

import java.net.ConnectException;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.ResourceAccessException;

import com.example.OrderService.OrderServiceApplication;
import com.example.OrderService.services.CartService;

public class CartController {
	Logger logger = LoggerFactory.getLogger(OrderServiceApplication.class);
	@Autowired
	private CartService cartService;
	// add to cart
	@GetMapping("/cart/add/{id}")
	public Object[] add(@PathVariable("id") Integer id) throws URISyntaxException, ConnectException {
		logger.info("Loading call api");
		try {
			cartService.addBookToCart(id);
			Object[] info = { cartService.getCount(), cartService.getTotal(), cartService.getItems() };
			return info;
		} catch (Exception ex) {
			logger.info("1" + ex.getMessage());
			if (ex instanceof ConnectException) {
				logger.info("2");
				throw new ConnectException(ex.getMessage());
			}
			if (ex instanceof ResourceAccessException) {
				logger.info("3");
				throw new ResourceAccessException(ex.getMessage());
			}
		}
		return null;
	}

	// remove from cart
	@GetMapping("/cart/remove/{id}")
	public Object[] removeFromCart(@PathVariable("id") Integer id) {
		cartService.removeFromCart(id);
		Object[] info = { cartService.getCount(), cartService.getTotal() };
		return info;
	}

}
