package net.py.backendshopping.daoimp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.py.backendshopping.dao.CartLineDAO;
import net.py.backendshopping.dto.Cart;
import net.py.backendshopping.dto.CartLine;
import net.py.backendshopping.dto.OrderDetail;

@Repository("cartLineDAO")
@Transactional
public class CartLineDAOimpl implements CartLineDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<CartLine> list(int cartId) {
		// TODO Auto-generated method stub
		String query = "FROM CartLine WHERE cartId = :cartId";
		return sessionFactory.getCurrentSession()
								.createQuery(query, CartLine.class)
									.setParameter("cartId", cartId)
										.getResultList();
	}

	@Override
	public CartLine get(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession()
				.get(CartLine.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(CartLine cartLineDTO) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(cartLineDTO);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(CartLine cartLineDTO) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(cartLineDTO);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(CartLine cartLineDTO) {
		// TODO Auto-generated method stub
		try {			
			sessionFactory.getCurrentSession().delete(cartLineDTO);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) {
		// TODO Auto-generated method stub
		String query = "FROM CartLine WHERE cartId = :cartId AND product.id = :productId";
		try {
			
			return sessionFactory.getCurrentSession()
									.createQuery(query,CartLine.class)
										.setParameter("cartId", cartId)
										.setParameter("productId", productId)
											.getSingleResult();
			
		}catch(Exception ex) {
			return null;	
		}
	}

	@Override
	public boolean updateCart(Cart cartDTO) {
		// TODO Auto-generated method stub
		try {			
			sessionFactory.getCurrentSession().update(cartDTO);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public List<CartLine> listAvailable(int cartId) {
		// TODO Auto-generated method stub
		String query = "FROM CartLine WHERE cartId = :cartId AND available = :available";
		return sessionFactory.getCurrentSession()
								.createQuery(query, CartLine.class)
									.setParameter("cartId", cartId)
									.setParameter("available", true)
										.getResultList();
	}

	@Override
	public boolean addOrderDetail(OrderDetail orderDetailDTO) {
		// TODO Auto-generated method stub
		try {			
			sessionFactory.getCurrentSession().persist(orderDetailDTO);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

}
