package com.example.UserService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserService.authen.UserPrincipal;
import com.example.UserService.models.Token;
import com.example.UserService.models.User;
import com.example.UserService.services.TokenService;
import com.example.UserService.services.UserService;
import com.example.UserService.util.JwtUtil;

@RestController
@RequestMapping("/api/v2")
public class UserController {
	@Autowired
	private UserService service;
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private TokenService tokenService;

	// get all user
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}

	// add user
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
	}

	// get user by id
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return service.getUerById(id);
	}

	// delete user by id
	@DeleteMapping("/user/{id}")
	public String deleteUserById(@PathVariable Long id) {
		return service.deleteUserById(id);
	}

	// update user
	@PatchMapping("/user/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return service.updateUser(id, user);
	}

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

		return service.createUser(user);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {

		UserPrincipal userPrincipal = service.findByUsername(user.getUsername());

		if (null == user || !new BCryptPasswordEncoder().matches(user.getPassword(), userPrincipal.getPassword())) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Account or password is not valid!");
		}

		Token token = new Token();
		token.setToken(jwtUtil.generateToken(userPrincipal));

		token.setTokenExpDate(jwtUtil.generateExpirationDate());
		token.setCreatedBy(userPrincipal.getUserId());
		tokenService.createToken(token);

		return ResponseEntity.ok(token.getToken());
	}

	@GetMapping("/hello")
	@PreAuthorize("hasAnyAuthority('USER_READ')")
	public ResponseEntity hello() {
		return ResponseEntity.ok("hello");
	}
}
