package com.example.UserService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserService.models.User;
import com.example.UserService.services.UserService;

@RestController
@RequestMapping("/api/v2")
public class UserController {
	@Autowired
	private UserService service;
	// get all user
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return service.getAllUsers();
	}
	// add user 
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
	}
	// get user by id
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Integer id) {
		return service.getUerById(id);
	}
}
