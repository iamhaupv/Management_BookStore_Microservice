package com.example.OrderService.controllers;

import java.net.ConnectException;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.example.OrderService.OrderServiceApplication;
import com.example.OrderService.models.Order;
import com.example.OrderService.services.OrderService;

@RestController
@RequestMapping("/api/v3/")
public class OrderController {
	@Autowired
	private OrderService orderService;
	Logger logger = LoggerFactory.getLogger(OrderServiceApplication.class);

	// get all list orders
	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	// create order
//	public Order saveOrder(@RequestBody Order order) {
//		order.setOrderDate(new Date());
//		order.setTotal(cartService.getAmount());
//		order.setStatus(1);
//		Collection<ProductDto> collection = cartService.getItems();
//		List<OrderDetail> details = new ArrayList<>();
//		for (ProductDto product : collection) {
//			OrderDetail orderDetail = new OrderDetail();
//			orderDetail.setOrder(order);
//			orderDetail.setProductId(product.getId());
//			orderDetail.setUnitPrice(product.getUnitPrice());
//			orderDetail.setQuantity(product.getQuantity());
//			orderDetail.setDiscount(product.getDiscount());
//			details.add(orderDetail);
//		}
//		cartService.clear();
//		return order;
//	}
	@GetMapping("/cart/add/{id}")
	public Object[] add(@PathVariable("id") Integer id) throws URISyntaxException, ConnectException {
		logger.info("Loading call api");
		try {
			orderService.addBookToCart(id);
			Object[] info = { orderService.getCount(), orderService.getTotal(), orderService.getItems() };
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
}
