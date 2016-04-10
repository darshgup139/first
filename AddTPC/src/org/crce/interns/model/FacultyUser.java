package org.crce.interns.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
//@Table(name = "role_function_schema.ftpc_special_role")
@Table(name = "sample.ftpc_special_role")
public class FacultyUser implements Serializable {

	@Id
	@Column(name = "username", nullable = false)
	@NotNull
	private String username;

	

	@Column(name = "special_role")
	private String userWork;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserWork() {
		return userWork;
	}

	public void setUserWork(String userWork) {
		this.userWork = userWork;
	}



}
