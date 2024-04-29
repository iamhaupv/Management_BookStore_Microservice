package com.example.spring_boot_api_jwt_ad.service;

import com.example.spring_boot_api_jwt_ad.authen.UserPrincipal;
import com.example.spring_boot_api_jwt_ad.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUerById(Long id);
    public User updateUser(Long id, User user);
    public String deleteUserById(Long id);
    User createUser(User user);
    UserPrincipal findByUsername(String username);
}
