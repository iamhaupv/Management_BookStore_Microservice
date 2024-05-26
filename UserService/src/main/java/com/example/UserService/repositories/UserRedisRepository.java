package com.example.UserService.repositories;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.UserService.entity.User;

@Repository
public class UserRedisRepository {
	private HashOperations hashOperations;
	private RedisTemplate redisTemplate;

	public UserRedisRepository(RedisTemplate redisTemplate) {
		this.hashOperations = redisTemplate.opsForHash();
		this.redisTemplate = redisTemplate;
	}

	public void saveUser(User user) {
		hashOperations.put("USER", user.getUsername(), user);
	}

	public List<User> findAll() {
		return hashOperations.values("USER");
	}

	public User getById(int id) {
		return (User) hashOperations.get("USER", id);
	}
}
