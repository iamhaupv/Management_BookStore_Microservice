package com.example.OrderService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OrderService.models.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
