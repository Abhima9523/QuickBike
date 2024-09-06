package com.jsp.dao;

import java.util.List;

import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jsp.entity.Orders;

@Repository
public class OrdersDao {
	@Autowired
	private EntityManager entityManager;

	public Orders getOrderById(int id) {
		return entityManager.find(Orders.class, id);
	}

	public void saveOrder(Orders orders) {
		EntityTransaction tran = entityManager.getTransaction();
		tran.begin();
		entityManager.persist(orders);
		tran.commit();
	}

	public List<Orders> getAllOrders() {
		Query q = entityManager.createQuery("select o from Orders o");
		return q.getResultList();
	}

	public void deleteOrders(int id) {
		EntityTransaction tran = entityManager.getTransaction();
		Orders o = getOrderById(id);
		tran.begin();
		entityManager.remove(o);
		tran.commit();
	}

	public void updateOrders(Orders orders) {
		EntityTransaction tran = entityManager.getTransaction();
		tran.begin();
		entityManager.merge(orders);
		tran.commit();
	}
}