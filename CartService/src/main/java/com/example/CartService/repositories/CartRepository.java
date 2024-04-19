package com.example.CartService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CartService.models.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
