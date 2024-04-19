package com.example.CartService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CartService.models.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

}
