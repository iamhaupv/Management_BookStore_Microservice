package com.example.UserService.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "t_token")
public class Role extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String roleKey;
	private String roleName;
	@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "t_role_permission", joinColumns = {@JoinColumn(name = "role_id")}, inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    private Set<Permission> permissions = new HashSet<>();
	public Role() {
		// TODO Auto-generated constructor stub
	}
	public Role(String roleKey, String roleName) {
		super();
		this.roleKey = roleKey;
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "Role [roleKey=" + roleKey + ", roleName=" + roleName + "]";
	}
	public String getRoleKey() {
		return roleKey;
	}
	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
