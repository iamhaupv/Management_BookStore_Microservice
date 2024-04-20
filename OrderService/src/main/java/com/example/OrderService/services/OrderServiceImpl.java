package com.example.OrderService.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.OrderService.OrderServiceApplication;
import com.example.OrderService.dto.BookDTO;
import com.example.OrderService.models.Order;
import com.example.OrderService.models.OrderDetail;
import com.example.OrderService.repositories.OrderDetailRepository;
import com.example.OrderService.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	Logger logger = LoggerFactory.getLogger(OrderServiceApplication.class);
	public Map<Integer, BookDTO> map = new HashMap<>();
	// add book to cart call BookService api
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
	// create oreder
	@Override
	public void create(Order order, List<OrderDetail> details) {
		orderRepository.save(order);
		for (OrderDetail orderDetail : details) {
			orderDetailRepository.save(orderDetail);
		}

	}
	// get all orders
	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
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
	public Collection<BookDTO> getItems() {
		return map.values();
	}

}
