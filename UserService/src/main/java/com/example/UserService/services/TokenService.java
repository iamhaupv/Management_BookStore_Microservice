package com.example.UserService.services;

import org.springframework.stereotype.Service;

import com.example.UserService.models.Token;

@Service
public interface TokenService {
	public Token createToken(Token token);

	public Token findByToken(String token);
}
