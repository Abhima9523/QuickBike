package com.jsp.dao;

import java.util.*;
import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.entity.Product;
@Repository
public class ProductDao {
	@Autowired
	private EntityManager entityManager;
	
	public Product getProductById(int id) {
		return entityManager.find(Product.class, id);
	}
	public void saveProduct(Product product) {
		EntityTransaction tran=entityManager.getTransaction();
		tran.begin();
		entityManager.persist(product);
		tran.commit();
	}
	public List<Product> getAllProduct(){
		Query q = entityManager.createQuery("select p from Product p");
		return q.getResultList();
	}
	public void deleteProduct(int id) {
		EntityTransaction tran=entityManager.getTransaction();
		Product p = getProductById(id);
		tran.begin();
		entityManager.remove(p);
		tran.commit();
	}
	public void UpdateProduct(Product product) {
		EntityTransaction tran=entityManager.getTransaction();
		tran.begin();
		entityManager.merge(product);
		tran.commit();
	}
}
