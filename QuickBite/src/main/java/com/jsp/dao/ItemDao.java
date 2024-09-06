package com.jsp.dao;

import java.util.*;
import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jsp.entity.Item;

@Repository
public class ItemDao {
	@Autowired
	private EntityManager entityManager;
	
	public Item getItemById(int id) {
		return entityManager.find(Item.class, id);
	}
	public void saveItem(Item item) {
		EntityTransaction tran=entityManager.getTransaction();
		tran.begin();
		entityManager.persist(item);
		tran.commit();
	}
	public List<Item> getAllItem(){
		Query q = entityManager.createQuery("select i from Item i");
		return q.getResultList();
	}
	public void deleteItem(int id) {
		EntityTransaction tran=entityManager.getTransaction();
		Item i = getItemById(id);
		tran.begin();
		entityManager.remove(i);
		tran.commit();
	}
	public void updateItem(Item item) {
		EntityTransaction tran=entityManager.getTransaction();
		tran.begin();
		entityManager.merge(item);
		tran.commit();
	}

}
