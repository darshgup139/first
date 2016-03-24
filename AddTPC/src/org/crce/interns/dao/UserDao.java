package org.crce.interns.dao;

import java.util.List;

import org.crce.interns.model.FacultyUser;
import org.crce.interns.model.RMUser;
import org.crce.interns.model.User;

public interface UserDao {
	public void insertUser(User user);

	public List<User> viewUsers();

	public void deleteUser(User user);

	public User getUser(User checkUser);

	public void insertWork(FacultyUser fuser);
	
	public FacultyUser getFacultyUser(FacultyUser fuser);

	public List<FacultyUser> viewFacultyTasks();
	
	public RMUser getUserRole(String role_id);

}
