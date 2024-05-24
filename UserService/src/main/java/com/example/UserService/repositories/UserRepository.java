package com.example.UserService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UserService.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

}
