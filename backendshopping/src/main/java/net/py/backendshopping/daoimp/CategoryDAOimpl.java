package net.py.backendshopping.daoimp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.py.backendshopping.dao.CategoryDAO;
import net.py.backendshopping.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOimpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub

		String selectActiveCategory = "FROM Category WHERE active = :active";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);

		query.setParameter("active", true);

		return query.getResultList();
	}

	@Override
	public boolean add(Category category) {
		// TODO Auto-generated method stub
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		category.setActive(false);

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
