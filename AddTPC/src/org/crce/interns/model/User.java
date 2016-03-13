package org.crce.interns.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sample.user_table")
public class User implements Serializable {

	@Id
	@Column(name = "user_name", nullable = false)
	@NotNull
	private String userName;

	@Column(name = "user_role", nullable = false)
	@NotNull
	private String userRole;

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
