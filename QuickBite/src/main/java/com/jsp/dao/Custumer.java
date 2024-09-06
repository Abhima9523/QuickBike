package com.jsp.dao;

import java.util.*;
import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jsp.entity.User;

@Repository
public class Custumer {
	@Autowired
	private EntityManager entityManager;

	public Custumer getCustomerById(int id) {
		return entityManager.find(Custumer.class, id);
	}

	public void saveCustomer(Custumer customer) {
		EntityTransaction tran = entityManager.getTransaction();
		tran.begin();
		entityManager.persist(customer);
		tran.commit();
	}

	public List<User> getAllCustomer() {
		Query q = entityManager.createQuery("select c from Customer c");
		return q.getResultList();
	}

	public void deleteCustomer(int id) {
		EntityTransaction tran = entityManager.getTransaction();
		Custumer c = getCustomerById(id);
		tran.begin();
		entityManager.remove(c);
		tran.commit();
	}

	public void updateCustomer(Custumer customer) {
		EntityTransaction tran = entityManager.getTransaction();
		tran.begin();
		entityManager.merge(customer);
		tran.commit();
	}
}
