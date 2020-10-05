package net.py.backendshopping.dao;

import java.util.List;

import net.py.backendshopping.dto.Address;
import net.py.backendshopping.dto.Cart;
import net.py.backendshopping.dto.User;

public interface UserDAO {
	// user related operation
	User getByEmail(String email);

	User get(int id);

	boolean add(User userDTO);

	boolean addAddress(Address addressDTO);

	boolean addCart(Cart cartDTO);

	// adding and updating a new address
	Address getAddress(int addressId);

	Address getBillingAddress(int userId);

	List<Address> listShippingAddresses(int userId);
}
