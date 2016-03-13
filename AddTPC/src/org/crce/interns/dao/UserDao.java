package org.crce.interns.dao;

import java.util.List;

import org.crce.interns.model.User;

public interface UserDao {
	public void insertUser(User user);

	public List<User> viewUsers();

	public void deleteUser(User user);

	public User getUser(User checkUser);

}
