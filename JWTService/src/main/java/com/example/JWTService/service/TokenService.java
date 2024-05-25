package com.example.JWTService.service;

import com.example.JWTService.entity.Token;

public interface TokenService {
    Token createToken(Token token);

    Token findByToken(String token);
}
