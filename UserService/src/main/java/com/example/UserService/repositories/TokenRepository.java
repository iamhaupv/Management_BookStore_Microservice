package com.example.UserService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UserService.models.Token;


@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
	public Token findByToken(String token);
}
