package com.example.UserService.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tokens")
public class Token extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(length = 1000)
	private String token;

	private Date tokenExpDate;

	@Override
	public String toString() {
		return "Token [token=" + token + ", tokenExpDate=" + tokenExpDate + "]";
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getTokenExpDate() {
		return tokenExpDate;
	}

	public void setTokenExpDate(Date tokenExpDate) {
		this.tokenExpDate = tokenExpDate;
	}

	public Token(String token, Date tokenExpDate) {
		super();
		this.token = token;
		this.tokenExpDate = tokenExpDate;
	}
	
}
