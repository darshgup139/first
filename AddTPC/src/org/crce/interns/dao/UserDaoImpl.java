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
		//entityManager.persist(user);
	//	List l=(List) entityManager.createQuery("");
		// from the user.username check if that entry is presetn in db
		// check the role of selected tuple
		// now if the role == studetn then new_role == studenttpc
		// else faculty tpc
		entityManager.merge(user);
	}
	@Override
	public List<User> viewUsers() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select u from User u", User.class).getResultList();
	}
	
	@Override
	public User getUser(User checkUser) {
		// TODO Auto-generated method stub
		String username=checkUser.getUsername();
		User user = (User)entityManager.createQuery("select u from User u where where u.userName = :n").setParameter("n", username), User.class);
		return user;
	}	
	
	@Override
	public void deleteUser(String userName) {
		// TODO Auto-generated method stub
		entityManager.createQuery("delete from User u where u.userName = :n").setParameter("n", userName).executeUpdate();
	}

}
