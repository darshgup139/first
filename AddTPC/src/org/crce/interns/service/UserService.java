package org.crce.interns.service;

import java.util.List;

import org.crce.interns.beans.FacultyUserBean;
import org.crce.interns.beans.UserBean;
import org.crce.interns.model.User;
import org.springframework.stereotype.Service;

public interface UserService {
	public void insertUser(UserBean userBean);

	public List<UserBean> viewUsers();

	public void deleteUser(UserBean userBean);

	public void insertWork(FacultyUserBean fuserBean);
	
	public List<FacultyUserBean> viewFacultyTasks();

}
