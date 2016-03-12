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
		User user = new User();
		User checkUser = new User();
		String st;
		BeanUtils.copyProperties(userBean, user);
		checkUser.setUserName(userBean.getUserName());

		checkUser = userDao.getUser(checkUser);

		System.out.println("User Role from JSP : " + userBean.getUserRole() + "\n");

		if (checkUser == null) {
			System.out.println("Error:No User Defined" + "\n");
		}

		System.out.println("User Role from DB : " + checkUser.getUserRole() + "\n");

		st = userBean.getUserRole();
		if (st.equalsIgnoreCase("Student")) {

			if (checkUser.getUserRole().equalsIgnoreCase(userBean.getUserRole())) {
				System.out.println("Before update Student Role : " + checkUser.getUserRole() + "\n");
				checkUser.setUserRole("Student-TPC");
				System.out.println("After update Student Role : " + checkUser.getUserRole() + "\n");
				userDao.insertUser(checkUser);
			} else {
				System.out.println("Invalid Input: Student" + "\n");
			}
		}

		else if (st.equalsIgnoreCase("Faculty")) {
			System.out.println(userBean.getUserRole());
			if (checkUser.getUserRole().equalsIgnoreCase(userBean.getUserRole())) {
				System.out.println("Before update Faculty Role : " + checkUser.getUserRole() + "\n");
				checkUser.setUserRole("Faculty-TPC");
				System.out.println("After update Faculty Role : " + checkUser.getUserRole() + "\n");
				userDao.insertUser(checkUser);
			} else {
				System.out.println("Invalid Input : Faculty" + "\n");
			}
		} else {
			System.out.println("Error : No Such User Exists");
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
	public void deleteUser(UserBean userBean) {
		// TODO Auto-generated method stub
		User user = new User();
		User checkUser = new User();
		BeanUtils.copyProperties(userBean, user);
		checkUser.setUserName(userBean.getUserName());

		checkUser = userDao.getUser(checkUser);

		if (checkUser == null) {
			System.out.println("Error:No User Defined" + "\n");
		}

		if (checkUser.getUserRole().equalsIgnoreCase("Student-TPC")) {
			System.out.println("Before update Student Role : " + checkUser.getUserRole() + "\n");
			checkUser.setUserRole("Student");
			System.out.println("After update Student Role : " + checkUser.getUserRole() + "\n");
			userDao.deleteUser(checkUser);
		} else if (checkUser.getUserRole().equalsIgnoreCase("Faculty-TPC")) {
			System.out.println("Before update Faculty Role : " + checkUser.getUserRole() + "\n");
			checkUser.setUserRole("Faculty");
			System.out.println("After update Faculty Role : " + checkUser.getUserRole() + "\n");
			userDao.deleteUser(checkUser);
		}

		else {
			System.out.println("Error : No Such User Exists");
		}
	}

}