package net.py.backendshopping.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.py.backendshopping.dao.ProductDAO;
import net.py.backendshopping.dto.Product;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;

	private static ProductDAO Productdao;

	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.py.backendshopping");
		context.refresh();
		Productdao = (ProductDAO) context.getBean("productDAO");
	}

//	@Test
//	public void testCRUDProduct() {
//		
//		// create operation
//		product = new Product();
//				
//		product.setName("Oppo Selfie S53");
//		product.setBrand("Oppo");
//		product.setDescription("This is some description for oppo mobile phones!");
//		product.setUnitPrice(25000);
//		product.setActive(true);
//		product.setCategoryId(3);
//		product.setSupplierId(3);
//		
//		assertEquals("Something went wrong while inserting a new product!",
//				true,Productdao.add(product));		
//		
//		
//		// reading and updating the category
//		product = Productdao.get(2);
//		product.setName("Samsung Galaxy S7");
//		assertEquals("Something went wrong while updating the existing record!",
//				true,Productdao.update(product));		
//				
//		assertEquals("Something went wrong while deleting the existing record!",
//				true,Productdao.delete(product));		
//		
//		// list
//		assertEquals("Something went wrong while fetching the list of products!",
//				6,Productdao.list().size());		
//			
//	}

//	@Test
//	public void testListActiveProducts() {
//		assertEquals("Something went wrong while fetching the list of products!", 5,
//				Productdao.listActiveProducts().size());
//	}
//
//	@Test
//	public void testListActiveProductsByCategory() {
//		assertEquals("Something went wrong while fetching the list of products!", 3,
//				Productdao.listActiveProductsByCategory(3).size());
//		assertEquals("Something went wrong while fetching the list of products!", 2,
//				Productdao.listActiveProductsByCategory(1).size());
//	}
//
	@Test
	public void testGetLatestActiveProduct() {
		assertEquals("Something went wrong while fetching the list of products!", 3,
				Productdao.getLatestActiveProducts(3).size());

	}
}
