package org.crce.interns.beans;

import java.io.Serializable;

public class UserBean implements Serializable {
	private String username;
	private String role_id;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	
}
