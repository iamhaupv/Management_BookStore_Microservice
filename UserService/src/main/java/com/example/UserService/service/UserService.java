package com.example.UserService.service;

import java.util.List;

import com.example.UserService.entity.User;


public interface UserService {
	public List<User> findAllUser();

	public void addUser(User user);
}
