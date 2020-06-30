package net.py.frontendshopping.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.slf4j.Logger;
import net.py.backendshopping.dao.CategoryDAO;
import net.py.backendshopping.dao.ProductDAO;
import net.py.backendshopping.dto.Category;
import net.py.backendshopping.dto.Product;
import net.py.frontendshopping.exception.ProductNotFoundException;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO CategoryDAO;

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = {"/home" })
	public ModelAndView index() {
		logger.debug("Inicio del controlador PageController, funcion index() - DEBUG");
		logger.info("Ejecutando vista: home.jsp");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Inicio");
		logger.debug("Ejecutando el controlador PageController, funcion index() - DEBUG");
		logger.debug("Ejecutando el controlador PageController, funcion index() - DEBUG");
		// passing the list of categories
		mv.addObject("categories", CategoryDAO.list());
//		if (logout != null) {
//			mv.addObject("message", "You have successfully logged out!");
//		}
		mv.addObject("userClickHome", true);
		logger.debug("Fin de la ejecucion, funcion index(). Valor retornado: " +mv);
		return mv;
	}

	// Productos disponibles
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		logger.debug("Inicio del controlador PageController, funcion showAllProducts() - DEBUG");
		logger.info("Ejecutando vista: listProducts.jsp");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Productos");
		logger.debug("Ejecutando el controlador PageController, funcion showAllProducts() - DEBUG");
		logger.debug("Ejecutando el controlador PageController, funcion showAllProducts() - DEBUG");
		
		// passing the list of categories
		mv.addObject("categories", CategoryDAO.list());
		
		mv.addObject("userClickAllProducts", true);
		logger.debug("Fin de la ejecucion, funcion showAllProducts(). Valor retornado: " +mv);
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		logger.debug("Inicio del controlador PageController, funcion showCategoryProducts() - DEBUG");
		logger.info("Ejecutando vista: listProducts.jsp");
		ModelAndView mv = new ModelAndView("page");
		// categoryDAO to fetch a single category
		Category category = null;
		category = CategoryDAO.get(id);
		mv.addObject("title", category.getName());
		logger.debug("Ejecutando el controlador PageController, funcion showCategoryProducts() - DEBUG");
		logger.debug("Ejecutando el controlador PageController, funcion showCategoryProducts() - DEBUG");
		// passing the list of categories
		mv.addObject("categories", CategoryDAO.list());
		// passing the single category object
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", true);
		logger.debug("Fin de la ejecucion, funcion showCategoryProducts(). Valor retornado: " +mv);
		return mv;
	}
	
	// Vista de un solo producto
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		logger.debug("Inicio del controlador PageController, funcion showSingleProduct() - DEBUG");
		logger.info("Ejecutando vista: singleProduct.jsp");
		ModelAndView mv = new ModelAndView("page");
		// Obtenemos el producto
		Product product = productDAO.get(id);
		if(product == null) throw new ProductNotFoundException();
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		mv.addObject("title", product.getName());
		logger.debug("Ejecutando el controlador PageController, funcion showSingleProduct() - DEBUG");
		logger.debug("Ejecutando el controlador PageController, funcion showSingleProduct() - DEBUG");
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		logger.debug("Fin de la ejecucion, funcion showSingleProduct(). Valor retornado: " +mv);
		return mv;
	}
	
}
