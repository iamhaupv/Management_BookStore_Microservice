package com.example.UserService.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_permission")
public class Permission extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String permissionName;

	private String permissionKey;

	public Permission() {
		// TODO Auto-generated constructor stub
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionKey() {
		return permissionKey;
	}

	public void setPermissionKey(String permissionKey) {
		this.permissionKey = permissionKey;
	}

	public Permission(String permissionName, String permissionKey) {
		super();
		this.permissionName = permissionName;
		this.permissionKey = permissionKey;
	}

	@Override
	public String toString() {
		return "Permission [permissionName=" + permissionName + ", permissionKey=" + permissionKey + "]";
	}

}
