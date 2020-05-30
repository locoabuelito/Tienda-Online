package net.py.frontendshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.py.backendshopping.dao.CategoryDAO;
//import net.py.backendshopping.dao.ProductDAO;
import net.py.backendshopping.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO CategoryDAO;

//	@Autowired
//	private ProductDAO productDAO;

	@RequestMapping(value = {"/home" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");

//		logger.info("Inside PageController index method - INFO");
//		logger.debug("Inside PageController index method - DEBUG");

		// passing the list of categories
		mv.addObject("categories", CategoryDAO.list());

//		if (logout != null) {
//			mv.addObject("message", "You have successfully logged out!");
//		}

		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contactos");
		mv.addObject("userClickContact", true);
		return mv;
	}

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Productos");

		// passing the list of categories
		mv.addObject("categories", CategoryDAO.list());

		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		// categoryDAO to fetch a single category
		Category category = null;

		category = CategoryDAO.get(id);

		mv.addObject("title", category.getName());

		// passing the list of categories
		mv.addObject("categories", CategoryDAO.list());

		// passing the single category object
		mv.addObject("category", category);

		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
}
