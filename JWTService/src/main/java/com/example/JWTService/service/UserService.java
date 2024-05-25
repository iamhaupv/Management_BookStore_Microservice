package com.example.JWTService.service;

import com.example.JWTService.authen.UserPrincipal;
import com.example.JWTService.entity.User;

public interface UserService {
    User createUser(User user);
    UserPrincipal findByUsername(String username);
}
