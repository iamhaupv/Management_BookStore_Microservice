package com.example.CartService.controllers;

import java.net.ConnectException;
import java.net.URISyntaxException;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.example.CartService.CartServiceApplication;
import com.example.CartService.dto.BookDTO;

@RestController
@RequestMapping("/api/v4/")
public class CartController {
	@Autowired
	private RestTemplate restTemplate;
	Logger logger = LoggerFactory.getLogger(CartServiceApplication.class);
	private static final String CARTSERVICE = "CartService";

	// add book to cart
	@GetMapping("/cart/add/{id}")
	@CachePut(value = "cart")
	public String addBookToCart(@PathVariable("id") Integer id) {
		logger.info("Loading call api order-service");
		String url = "http://localhost:8083/api/v3/cart/add/" + id;
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

		return "Addd book to cart successfully!";
	}

	// remove book from cart
	@GetMapping("/cart/remove/{id}")
	@CacheEvict(value = "cart", allEntries = true)
	public String removeBookFromCart(@PathVariable("id") Integer id) {
		logger.info("Loading call api order-service");
		String url = "http://localhost:8083/api/v3/cart/remove/" + id;
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

		return "Remove book from cart successfully!";
	}

	// view cart
	@GetMapping("/cart/view")
	@Cacheable(value = "cart")
	public Collection<BookDTO> getView() throws URISyntaxException, ConnectException {
		logger.info("Loading call api order-service");
		try {
			String url = "http://localhost:8083/api/v3/cart/view";
			ResponseEntity<Collection<BookDTO>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<Collection<BookDTO>>() {
					});
			Collection<BookDTO> products = responseEntity.getBody();
			return products;
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

	// clear cart
	@GetMapping("/cart/clear")
	@CacheEvict(value = "cart", allEntries = true)
	public String clear() {
		String url = "http://localhost:8083/api/v3/cart/clear";
		ResponseEntity<BookDTO> responseEntity = restTemplate.getForEntity(url, BookDTO.class);

		return "Clear cart successfully";
	}

}
