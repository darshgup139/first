package org.crce.interns.service;

import java.util.ArrayList;
import java.util.List;

import org.crce.interns.beans.FacultyUserBean;
import org.crce.interns.beans.UserBean;
import org.crce.interns.dao.UserDao;
import org.crce.interns.model.FacultyUser;
import org.crce.interns.model.RMUser;
import org.crce.interns.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	/*Methods to Insert the data */
	@Override
	public void insertUser(UserBean userBean) {
		User user = new User();
		User checkUser = new User();
		RMUser rmuser= new RMUser();
		String st;
		BeanUtils.copyProperties(userBean, user);
		checkUser.setUsername(userBean.getUsername());

		checkUser = userDao.getUser(checkUser);

		System.out.println("User Role ID from JSP : " + userBean.getRole_id() + "\n");
		String roleID=userBean.getRole_id();
		System.out.println(roleID);
		rmuser=userDao.getUserRole(roleID);
		
		System.out.println("User Id in RM Table: "+rmuser.getRole_id());
		System.out.println("User Role in RM Table: "+rmuser.getUserRole());
		
		if (checkUser == null) {
			System.out.println("Error:No User Defined" + "\n");
		}

		System.out.println("User Role ID from DB : " + checkUser.getRole_id() + "\n");
		/*
		 *1-Student 
		 *2-Faculty
		 *3-Student-TPC
		 *4-Faculty-TPC
		 */
		st = userBean.getRole_id();
		if (st.equalsIgnoreCase("1")) {

			if (checkUser.getRole_id().equalsIgnoreCase(userBean.getRole_id())) {
				System.out.println("Before update Student Role ID : " + checkUser.getRole_id() + "\n");
				checkUser.setRole_id("3");
				System.out.println("After update Student Role ID : " + checkUser.getRole_id() + "\n");
				userDao.insertUser(checkUser);
			} else {
				System.out.println("Invalid Input: Student" + "\n");
			}
		}

		else if (st.equalsIgnoreCase("2")) {
			System.out.println(userBean.getRole_id());
			if (checkUser.getRole_id().equalsIgnoreCase(userBean.getRole_id())) {
				System.out.println("Before update Faculty Role ID : " + checkUser.getRole_id() + "\n");
				checkUser.setRole_id("4");
				System.out.println("After update Faculty Role ID : " + checkUser.getRole_id() + "\n");
				userDao.insertUser(checkUser);
			} else {
				System.out.println("Invalid Input : Faculty" + "\n");
			}
		} else {
			System.out.println("Error : No Such User Exists");
		}

	}
	
	@Override
	public void insertWork(FacultyUserBean fuserBean) {
		FacultyUser fuser = new FacultyUser();
		
		fuser.setUsername(fuserBean.getUsername());
		
		fuser = userDao.getFacultyUser(fuser);
		fuser.setUserWork(fuserBean.getUserWork());
		System.out.println("Username in Service IMPL :"+fuser.getUsername());
		System.out.println("UserWork in Service IMPL :"+fuser.getUserWork());
		System.out.println("UserWorkk in Service with Bean: "+fuserBean.getUserWork());
		if (fuser == null) {
			System.out.println("Error:No User Defined" + "\n");
		}
		//System.out.println("Username in Service IMPL :"+fuser.getUserName());
		userDao.insertWork(fuser);
		// TODO Auto-generated method stub
	}
	
	

	/*Methods to Convert to Bean the data */
	public List<UserBean> convertToBean(List<User> userList) {
		List<UserBean> userBeanList = new ArrayList<UserBean>();
		for (User user : userList) {
			UserBean userBean = new UserBean();
			BeanUtils.copyProperties(user, userBean);
			userBeanList.add(userBean);
		}
		return userBeanList;
	}
	
	public List<FacultyUserBean> convertToBeanFaculty(List<FacultyUser> userList) {
		List<FacultyUserBean> userBeanList = new ArrayList<FacultyUserBean>();
		for (FacultyUser fuser : userList) {
			FacultyUserBean fuserBean = new FacultyUserBean();
			BeanUtils.copyProperties(fuser, fuserBean);
			userBeanList.add(fuserBean);
		}
		return userBeanList;
	}


	
	/*Methods to Delete the data */
	@Override
	public void deleteUser(UserBean userBean) {
		// TODO Auto-generated method stub
		User user = new User();
		User checkUser = new User();
		BeanUtils.copyProperties(userBean, user);
		checkUser.setUsername(userBean.getUsername());

		checkUser = userDao.getUser(checkUser);

		if (checkUser == null) {
			System.out.println("Error:No User Defined" + "\n");
		}

		if (checkUser.getRole_id().equalsIgnoreCase("3")) {
			System.out.println("Before update Student Role : " + checkUser.getRole_id() + "\n");
			checkUser.setRole_id("1");//1 is Student & 3 is Student tpc
			System.out.println("After update Student Role : " + checkUser.getRole_id() + "\n");
			userDao.deleteUser(checkUser);
		} else if (checkUser.getRole_id().equalsIgnoreCase("4")) {
			System.out.println("Before update Faculty Role : " + checkUser.getRole_id() + "\n");
			checkUser.setRole_id("2");//2 is faculty & 4 is Fac tpc
			System.out.println("After update Faculty Role : " + checkUser.getRole_id() + "\n");
			userDao.deleteUser(checkUser);
		}

		else {
			System.out.println("Error : No Such User Exists");
		}
	}
	
	
	
	/*Methods to View the data */
	@Override
	public List<UserBean> viewUsers() {
		// TODO Auto-generated method stub
		List<User> userList = userDao.viewUsers();
		return convertToBean(userList);
	}

	@Override
	public List<FacultyUserBean> viewFacultyTasks() {
		// TODO Auto-generated method stub
		List<FacultyUser> userList = userDao.viewFacultyTasks();
		return convertToBeanFaculty(userList);
	}

	

}