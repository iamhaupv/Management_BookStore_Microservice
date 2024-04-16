package com.example.UserService.services;

import org.springframework.stereotype.Service;

import ch.qos.logback.core.subst.Token;
@Service
public interface TokenService {
	public Token createToken(Token token);
    public Token findByToken(String token);
}
