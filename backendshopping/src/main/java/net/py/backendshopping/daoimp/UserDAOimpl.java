package net.py.backendshopping.daoimp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.py.backendshopping.dao.UserDAO;
import net.py.backendshopping.dto.Address;
import net.py.backendshopping.dto.Cart;
import net.py.backendshopping.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOimpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		String selectQuery = "FROM User WHERE email = :email";
		try {
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectQuery,User.class)
						.setParameter("email",email)
							.getSingleResult();
		}
		catch(Exception ex) {
			return null;
		}
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		try {			
			return sessionFactory.getCurrentSession().get(User.class, id);			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public boolean add(User userDTO) {
		// TODO Auto-generated method stub
		try {			
			sessionFactory.getCurrentSession().persist(userDTO);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public Address getAddress(int addressId) {
		// TODO Auto-generated method stub
		try {			
			return sessionFactory.getCurrentSession().get(Address.class, addressId);			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public boolean addAddress(Address addressDTO) {
		// TODO Auto-generated method stub
		try {			
			// will look for this code later and why we need to change it
			sessionFactory.getCurrentSession().persist(addressDTO);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
	
	@Override
	public boolean addCart(Cart cartDTO) {
		// TODO Auto-generated method stub
		try {			
			// will look for this code later and why we need to change it
			sessionFactory.getCurrentSession().persist(cartDTO);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
	/*
	@Override
	public boolean updateAddress(Address addressDTO) {
		// TODO Auto-generated method stub
		try {			
			sessionFactory.getCurrentSession().update(addressDTO);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}*/

	@Override
	public Address getBillingAddress(int userId) {
		// TODO Auto-generated method stub
		String selectQuery = "FROM Address WHERE userId = :userId AND billing = :isBilling";
		try{
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectQuery,Address.class)
						.setParameter("userId", userId)
						.setParameter("isBilling", true)
						.getSingleResult();
		}
		catch(Exception ex) {
			return null;
		}
	}

	@Override
	public List<Address> listShippingAddresses(int userId) {
		// TODO Auto-generated method stub
		String selectQuery = "FROM Address WHERE userId = :userId AND shipping = :isShipping ORDER BY id DESC";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectQuery,Address.class)
						.setParameter("userId", userId)
						.setParameter("isShipping", true)
							.getResultList();
	}

}
