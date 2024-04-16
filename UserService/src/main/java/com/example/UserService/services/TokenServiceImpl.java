package com.example.UserService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserService.repositories.TokenRepository;

import ch.qos.logback.core.subst.Token;

@Service
public class TokenServiceImpl implements TokenService {

	@Autowired
	private TokenRepository tokenRepository;

	public Token createToken(Token token) {
		return tokenRepository.saveAndFlush(token);
	}

	@Override
	public Token findByToken(String token) {
		return tokenRepository.findByToken(token);
	}

}
