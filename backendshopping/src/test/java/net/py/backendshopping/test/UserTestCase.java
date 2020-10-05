package net.py.backendshopping.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.py.backendshopping.dao.UserDAO;
import net.py.backendshopping.dto.Address;
import net.py.backendshopping.dto.Cart;
import net.py.backendshopping.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.py.backendshopping");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
	}

	@Test
	public void testAdd() {
		user = new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setEnabled(true);
		user.setPassword("12345");

		assertEquals("Failed to add the user!", true, userDAO.add(user));

		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);

		// linked the address with the user
		address.setUserId(user.getId());
		// add the address
		assertEquals("Failed to add the billing address!", true, userDAO.addAddress(address));

		if (user.getRole().equals("USER")) {
			cart = new Cart();
			cart.setUserId(user.getId());

			// add the cart
			assertEquals("Failed to add the cart!", true, userDAO.addCart(cart));
			// add the address
			assertEquals("Failed to add the billing address!", true, userDAO.addAddress(address));

			// add the shipping address
			address = new Address();
			address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
			address.setAddressLineTwo("Near Kudrat Store");
			address.setCity("Mumbai");
			address.setState("Maharashtra");
			address.setCountry("India");
			address.setPostalCode("400001");
			address.setShipping(true);
			address.setUserId(user.getId());
			assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
		}
	}
}
