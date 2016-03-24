package org.crce.interns.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.crce.interns.model.FacultyUser;
import org.crce.interns.model.RMUser;
import org.crce.interns.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	
	/*Methods to Insert*/
	@Override
	public void insertUser(User user) {
		entityManager.merge(user);
	}
	
	@Override
	public void insertWork(FacultyUser fuser) {
		entityManager.merge(fuser);
		// TODO Auto-generated method stub
		
	}

	
	
	/*Methods to View*/
	@Override
	public List<User> viewUsers() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select u from User u", User.class).getResultList();
		//return entityManager.
	}
	
	@Override
	public List<FacultyUser> viewFacultyTasks() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select u from FacultyUser u", FacultyUser.class).getResultList();
	}

	
	
	/*Methods to Get */
	public User getUser(User checkUser) {
		// TODO Auto-generated method stub
		String userName = checkUser.getUsername();
		User user = (User) entityManager.createQuery("select u from User u where u.username = :n")
				.setParameter("n", userName).getSingleResult();
		return user;
	}

	public FacultyUser getFacultyUser(FacultyUser fuser) {
		// TODO Auto-generated method stub
		String userName = fuser.getUsername();
		System.out.println("Username in DAO IMPL before query :"+fuser.getUserWork());
		
		FacultyUser fuser1 = (FacultyUser) entityManager.createQuery("select f from FacultyUser f where f.username = :n")
				.setParameter("n", userName).getSingleResult();
		if(fuser1==null)
		{
			System.out.println("Error : User not present in Faculty Table");
		}
		System.out.println("UserName in DAO IMPL after query:"+fuser1.getUsername());
		System.out.println("UserWork in DAO IMPL after query:"+fuser1.getUserWork());
		
		return fuser1;
	}
	
	public RMUser getUserRole(String role_id)
	{
		//RMUser rmuser = new RMUser();
		RMUser rmuser = (RMUser) entityManager.createQuery("select r from RMUser r where r.role_id = :n")
				.setParameter("n",role_id).getSingleResult();
		return rmuser;
	}
	
	
	/*Methods to Delete*/
	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		entityManager.merge(user);
	}

	

	

	
}