package net.py.frontendshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.py.backendshopping.dao.CategoryDAO;
import net.py.backendshopping.dao.ProductDAO;
import net.py.backendshopping.dto.Category;
import net.py.backendshopping.dto.Product;
import net.py.frontendshopping.util.FileUtil;
import net.py.frontendshopping.validator.ImgProductValidator;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	// Vista - Panel de Productos
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView mangeProduct(@RequestParam(name = "success", required = false) String success) {
		logger.debug("Inicio del controlador ManagementController, funcion mangeProduct() - DEBUG");
		logger.info("Ejecutando vista: manageProduct.jsp");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Control de Productos");
		mv.addObject("userClickManageProduct", true);

		Product nProduct = new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);

		mv.addObject("product", nProduct);

		if (success != null) {
			if (success.equals("product")) {
				mv.addObject("message", "Producto ingresado exitosamente!");
			} else if (success.equals("category")) {
				mv.addObject("message", "Categoria ingresado exitosamente!");
			}
		}

		logger.debug("Fin de la ejecucion, funcion mangeProduct. Valor retornado: " + mv);
		return mv;
	}

	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.list();
	}

	@RequestMapping(value = "/{id}/product", method = RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id) {
		logger.debug("Inicio del controlador ManagementController, funcion showEditProduct() - DEBUG");
		logger.info("Ejecutando vista: manageProduct.jsp");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Control de Productos");
		mv.addObject("userClickManageProduct", true);

		Product nProduct = productDAO.get(id);
		mv.addObject("product", nProduct);

		return mv;

	}

	// Guardar productos
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String managePostProduct(@Valid @ModelAttribute("product") Product mProduct, BindingResult results,
			Model model, HttpServletRequest request) {

		if (mProduct.getId() == 0) {
			new ImgProductValidator().validate(mProduct, results);
		} else {
			if (!mProduct.getFile().getOriginalFilename().equals("")) {
				new ImgProductValidator().validate(mProduct, results);
			}
		}

		if (results.hasErrors()) {
			model.addAttribute("title", "Control de Productos");
			model.addAttribute("userClickManageProduct", true);
			return "page";
		}

		if (!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUtil.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}

		if (mProduct.getId() == 0) {
			productDAO.add(mProduct);
		} else {
			productDAO.update(mProduct);
		}
		return "redirect:/manage/products?success=product";
	}

	// Activacion y desactivacion de productos
	@RequestMapping(value = "/products/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handlerActivationProduc(@PathVariable int id) {

		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		product.setActive(!isActive);
		productDAO.update(product);
		return (isActive) ? "Producto Desactivado exitosamente!" : "Producto Activado exitosamente!";
	}
}
