package com.example.OrderService.services;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.OrderService.dto.BookDTO;
import com.example.OrderService.models.Order;
import com.example.OrderService.models.OrderDetail;

@Service
public interface OrderService {
	public void create(Order order, List<OrderDetail> orderDetails);

	public List<Order> getAllOrders();

	public void addBookToCart(Integer id);

	public int getCount();

	public double getTotal();

	public Collection<BookDTO> getItems();
}
