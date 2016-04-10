package org.crce.interns.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_schema.userdetails")
//@Table(name = "sample.userdetails")
public class User implements Serializable {

	@Id
	@Column(name = "username", nullable = false)
	@NotNull
	private String username;

	@Column(name = "role_id")
	@NotNull
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
