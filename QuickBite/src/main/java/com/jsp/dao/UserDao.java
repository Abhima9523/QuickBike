package com.jsp.dao;
import java.util.List;
import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jsp.entity.User;

@Repository
public class UserDao {
	@Autowired
	private EntityManager entityManager;
	
	public User getUserById(int id) {
		return entityManager.find(User.class, id);
	}
	public void saveUser(User user) {
		EntityTransaction tran=entityManager.getTransaction();
		tran.begin();
		entityManager.persist(user);
		tran.commit();
	}
	public List<User> getAllUser(){
		Query q = entityManager.createQuery("select u from User u");
		return q.getResultList();
	}
	
	public void deleteUser(int id) {
		EntityTransaction tran=entityManager.getTransaction();
		User u = getUserById(id);
		tran.begin();
		entityManager.remove(u);
		tran.commit();
	}
	public void updateUser(User user) {
		EntityTransaction tran=entityManager.getTransaction();
		tran.begin();
		entityManager.merge(user);
		tran.commit();
	}
}
