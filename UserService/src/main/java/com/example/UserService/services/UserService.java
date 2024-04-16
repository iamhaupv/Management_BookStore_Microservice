package com.example.UserService.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.UserService.authen.UserPrincipal;
import com.example.UserService.models.User;

@Service
public interface UserService {
	public List<User> getAllUsers();
	public User addUser(User user);
	public User getUerById(Long id);
	public User updateUser(Long id, User user);
	public String deleteUserById(Long id);
	public User createUser(User user);
    public UserPrincipal findByUsername(String username);
}
