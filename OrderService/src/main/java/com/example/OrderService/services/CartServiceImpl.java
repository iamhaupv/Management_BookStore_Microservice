package com.example.OrderService.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.OrderService.dto.BookDTO;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private RestTemplate restTemplate;
	public Map<Integer, BookDTO> map = new HashMap<>();
	private static final String CART_CACHE_NAME = "cart";

	// add book to cart call BookService api
	@CachePut(value = CART_CACHE_NAME)
	public void addBookToCart(Integer id) {
		BookDTO p = map.get(id);
		String url = "http://localhost:8081/api/v1/book/" + id;
		ResponseEntity<BookDTO> reponse = restTemplate.getForEntity(url, BookDTO.class);
		if (p == null) {
			p = reponse.getBody();
			p.setQuantity(1);
			map.put(id, p);
		} else {
			p.setQuantity(p.getQuantity() + 1);
		}
	}

	// get count
	@Override
	public int getCount() {
		Collection<BookDTO> ps = this.getItems();
		int count = 0;
		for (BookDTO p : ps) {
			count += p.getQuantity();
		}
		return count;
	}

	// get total
	@Override
	public double getTotal() {
		Collection<BookDTO> ps = this.getItems();
		double amount = 0;
		for (BookDTO p : ps) {
			amount += p.getQuantity() * p.getUnitPrice() * (1 - p.getDiscount());
		}
		return amount;
	}

	// items
	@Override
	@Cacheable(value = CART_CACHE_NAME)
	public Collection<BookDTO> getItems() {
		return map.values();
	}

	// remove from cart
	@Override
	@CacheEvict(value = CART_CACHE_NAME, allEntries = true)
	public void removeBookFromCart(Integer id) {
		map.remove(id);
	}

	// clear cart
	@Override
	@CacheEvict(value = CART_CACHE_NAME, allEntries = true)
	public void clearCart() {
		map.clear();
	}

}
