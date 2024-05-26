package com.example.UserService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserService.entity.User;
import com.example.UserService.repositories.UserRepository;

@Service
public class UserServiceImlp implements UserService {
	@Autowired
	UserRepository userReponsive;

	@Override
	public List<User> findAllUser() {
		List<User> users = new ArrayList<>();
		users = userReponsive.findAll();
		return users;
	}

	@Override
	public void addUser(User user) {
		userReponsive.save(user);
	}
}
