package org.crce.interns.service;

import java.util.ArrayList;
import java.util.List;

import org.crce.interns.beans.UserBean;
import org.crce.interns.dao.UserDao;
import org.crce.interns.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public void insertUser(UserBean userBean) {
		// TODO Auto-generated method stub
	User user = new User();
		User checkUser = new User();
		
		
		BeanUtils.copyProperties(userBean, user);
		checkUser.setUserName(userBean.getUserName());
		
		checkUser=userDao.getUser(checkUser);
		
		
		System.out.println(userBean.getUserRole());
		
		
		if(checkUser==null)
		{
			System.out.println("Error hello");
		}
		
		//System.out.println(checkUser.getUserRole());
		String st;
		st=userBean.getUserRole();
		if(st.equalsIgnoreCase("Student"))
		{
			
		if(checkUser.getUserRole().equalsIgnoreCase(userBean.getUserRole())){
		  //do something
			//System.out.println("Hello In student");
		  checkUser.setUserRole("Student-TPC");
		//System.out.println(checkUser.getUserRole());
		userDao.insertUser(checkUser);
		}
		else
		{
			System.out.println("error:Invalid Input Student");
		}
		}
		
		else if(st.equalsIgnoreCase("Faculty")){
			System.out.println(userBean.getUserRole());
			if(checkUser.getUserRole().equalsIgnoreCase(userBean.getUserRole())){
				
			  //do something
			//System.out.println("Hello In faculty");
		//	System.out.println(checkUser.getUserRole());
			  checkUser.setUserRole("Faculty-TPC");
		//	  System.out.println(checkUser.getUserRole());
			  userDao.insertUser(checkUser);
			}
			else{
				System.out.println("error:Invalid Input Faculty");
			}
		}
		else
		{
			System.out.println("error");
		}

	}

	@Override
	public List<UserBean> viewUsers() {
		// TODO Auto-generated method stub
		List<User> userList = userDao.viewUsers();
		return convertToBean(userList);
	}

	public List<UserBean> convertToBean(List<User> userList) {
		List<UserBean> userBeanList = new ArrayList<UserBean>();
		for (User user : userList) {
			UserBean userBean = new UserBean();
			BeanUtils.copyProperties(user, userBean);
			userBeanList.add(userBean);
		}
		return userBeanList;
	}

	@Override
	public void deleteUser(String userName) {
		// TODO Auto-generated method stub
		userDao.deleteUser(userName);

	}

}