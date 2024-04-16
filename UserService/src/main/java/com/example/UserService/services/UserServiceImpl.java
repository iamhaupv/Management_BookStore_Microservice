package com.example.UserService.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserService.authen.UserPrincipal;
import com.example.UserService.models.User;
import com.example.UserService.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
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
	public User getUerById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public User updateUser(Long id, User userNew) {
	    Optional<User> optionalUser = repository.findById(id);
	    if (optionalUser.isPresent()) {
	        User userOld = optionalUser.get();
	        if (userNew.getPassword() != null && !userNew.getPassword().isEmpty()) {
	            userOld.setPassword(userNew.getPassword());
	        }
	        return repository.save(userOld);
	    }
	    return null; 
	}


	@Override
	public String deleteUserById(Long id) {
		repository.deleteById(id);
		return "Delete user successfully!";
	}

	@Override
	public User createUser(User user) {
		return repository.saveAndFlush(user);
	}

	@Override
	public UserPrincipal findByUsername(String username) {
		User user = repository.findByUsername(username);
		UserPrincipal userPrincipal = new UserPrincipal();

		if (null != user) {

			Set<String> authorities = new HashSet<>();

			if (null != user.getRoles())

				user.getRoles().forEach(r -> {
					authorities.add(r.getRoleKey());
					r.getPermissions().forEach(p -> authorities.add(p.getPermissionKey()));
				});

			userPrincipal.setUserId(user.getId());
			userPrincipal.setUsername(user.getUsername());
			userPrincipal.setPassword(user.getPassword());
			userPrincipal.setAuthorities(authorities);

		}
		return userPrincipal;
	}
}
