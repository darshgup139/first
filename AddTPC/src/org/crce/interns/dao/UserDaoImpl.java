package org.crce.interns.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.crce.interns.model.FacultyUser;
import org.crce.interns.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public List<User> viewUsers() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select u from User u", User.class).getResultList();
	}
	
	@Override
	public List<FacultyUser> viewFacultyTasks() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select u from FacultyUser u", FacultyUser.class).getResultList();
	}


	public User getUser(User checkUser) {
		// TODO Auto-generated method stub
		String userName = checkUser.getUserName();
		User user = (User) entityManager.createQuery("select u from User u where u.userName = :n")
				.setParameter("n", userName).getSingleResult();
		return user;
	}

	public FacultyUser getFacultyUser(FacultyUser fuser) {
		// TODO Auto-generated method stub
		String userName = fuser.getUserName();
		System.out.println("Username in DAO IMPL before query :"+fuser.getUserWork());
		
		FacultyUser fuser1 = (FacultyUser) entityManager.createQuery("select f from FacultyUser f where f.userName = :n")
				.setParameter("n", userName).getSingleResult();
		if(fuser1==null)
		{
			System.out.println("Error : User not present in Faculty Table");
		}
		System.out.println("UserName in DAO IMPL after query:"+fuser1.getUserName());
		System.out.println("UserWork in DAO IMPL after query:"+fuser1.getUserWork());
		
		return fuser1;
	}
	
	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		entityManager.merge(user);
	}

	@Override
	public void insertWork(FacultyUser fuser) {
		entityManager.merge(fuser);
		// TODO Auto-generated method stub
		
	}

	

	
}