package com.example.UserService.services;

import ch.qos.logback.core.subst.Token;

public interface TokenService {
	public Token createToken(Token token);
    public Token findByToken(String token);
}
