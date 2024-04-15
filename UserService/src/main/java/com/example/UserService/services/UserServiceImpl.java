package com.example.UserService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserService.models.User;
import com.example.UserService.repositories.UserRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository repository;
	
	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public User addUser(User user) {
		return repository.save(user);
	}

	@Override
	public User getUerById(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public User updateUser(Integer id, User userNew) {
	    User userOld = repository.findById(id).orElse(null);
	    if (userOld != null) {
	        if (userNew.getPassword() != null && !userNew.getPassword().isEmpty()) {
	            userOld.setPassword(userNew.getPassword());
	            return repository.save(userOld);
	        }
	    }
	    return null;
	}


	@Override
	public String deleteUserById(Integer id) {
		repository.deleteById(id);
		return "Delete user successfully!";
	}

}
