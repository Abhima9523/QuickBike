package com.jsp.dao;
import java.util.List;
import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jsp.entity.Menu;

@Repository
public class MenuDao {
	@Autowired
	private EntityManager entityManager;

	public Menu getMenuById(int id) {
		return entityManager.find(Menu.class, id);
	}

	public void saveMenu(Menu menu) {
		EntityTransaction tran = entityManager.getTransaction();
		tran.begin();
		entityManager.persist(menu);
		tran.commit();
	}

	public List<Menu> getAllMenu() {
		Query q = entityManager.createQuery("select m from Menu m");
		return q.getResultList();
	}

	public void deleteMenu(int id) {
		EntityTransaction tran = entityManager.getTransaction();
		Menu m = getMenuById(id);
		tran.begin();
		entityManager.remove(m);
		tran.commit();
	}

	public void updateMenu(Menu menu) {
		EntityTransaction tran = entityManager.getTransaction();
		tran.begin();
		entityManager.merge(menu);
		tran.commit();
	}

}
