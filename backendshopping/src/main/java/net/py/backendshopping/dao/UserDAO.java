package net.py.backendshopping.dao;

import java.util.List;

import net.py.backendshopping.dto.Address;
import net.py.backendshopping.dto.User;

public interface UserDAO {
	// user related operation
	User getByEmail(String email);

	User get(int id);

	boolean add(User userDTO);

	// adding and updating a new address
	Address getAddress(int addressId);

	boolean addAddress(Address addressDTO);

	boolean updateAddress(Address addressDTO);

	Address getBillingAddress(int userId);

	List<Address> listShippingAddresses(int userId);
}
