package com.example.OrderService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OrderService.models.Order;
import com.example.OrderService.models.OrderDetail;
import com.example.OrderService.repositories.OrderDetailRepository;
import com.example.OrderService.repositories.OrderRepository;
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	OrderDetailRepository orderDetailRepository;

	@Override
	public void create(Order order, List<OrderDetail> details) {
		orderRepository.save(order);
		for (OrderDetail orderDetail : details) {
			orderDetailRepository.save(orderDetail);
		}

	}


}
