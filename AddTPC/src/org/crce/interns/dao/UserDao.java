package org.crce.interns.dao;

import java.util.List;

import org.crce.interns.model.User;

public interface UserDao {
	public void insertUser(User user);

	public List<User> viewUsers();
	public void deleteUser(String userName);

	public User getUser(User checkUser);

	//User getUser(String userName);
}
