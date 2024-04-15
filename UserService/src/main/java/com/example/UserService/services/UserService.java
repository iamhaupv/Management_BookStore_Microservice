package com.example.UserService.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.UserService.models.User;

@Service
public interface UserService {
	public List<User> getAllUsers();
	public User addUser(User user);
	public User getUerById(Integer id);
	public User updateUser(Integer id, User user);
	public String deleteUserById(Integer id);
}
