package com.example.UserService.models;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable(name = "t_user_rolF", joinColumns = {@JoinColumn(name = "user_id")},
	            inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private Set<Role> roles = new HashSet<>();
	public User() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
