package org.crce.interns.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.crce.interns.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		//user.setUserRole("Student");
		//System.out.println(user.getUserRole());
		entityManager.merge(user);
	}
	@Override
	public List<User> viewUsers() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select u from User u", User.class).getResultList();
	}
	
/*	@Override
	public User getUser(User checkUser) {
		// TODO Auto-generated method stub
		User user =entityManager.createQuery("select u from User u where where u.userName = :n").setParameter("n", username), User.class);
		return user;
	}	
	*/
	public User getUser(User checkUser) {
  		// TODO Auto-generated method stub
 		String userName=checkUser.getUserName();
  		User user = (User)entityManager.createQuery("select u from User u where u.userName = :n").setParameter("n", userName).getSingleResult();
 		return user;
  	}	
	
	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		entityManager.merge(user);
		//entityManager.createQuery("delete from User u where u.userName = :n").setParameter("n", userName).executeUpdate();
	}

}