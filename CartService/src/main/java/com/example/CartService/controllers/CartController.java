package com.example.CartService.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.CartService.CartServiceApplication;


@RestController
@RequestMapping("/api/v4/")
public class CartController {
	@Autowired
	private RestTemplate restTemplate;
	Logger logger = LoggerFactory.getLogger(CartServiceApplication.class);
	private static final String CARTSERVICE = "CartService";
	
	@GetMapping("/cart/add/{id}")
	public String add(@PathVariable("id") Integer id) {
		logger.info("Đang gọi api nhé");
		String url = "http://localhost:8083/api/v3/cart/add/" + id;
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		return "Addd book to cart successfully!";
	}

}
