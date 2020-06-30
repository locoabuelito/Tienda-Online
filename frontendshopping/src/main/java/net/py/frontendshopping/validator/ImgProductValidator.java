package net.py.frontendshopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.py.backendshopping.dto.Product;

public class ImgProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Product product = (Product) target;
		// Pregunta si selecciono una imagen
		if (product.getFile() == null || product.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Por favor, seleccione una imagen!");
			return;
		}
		// Valida los formatos para las imagenes a seleccionar
		if (!(product.getFile().getContentType().equals("image/jpeg")
				|| product.getFile().getContentType().equals("image/png"))
				|| product.getFile().getContentType().equals("image/gif")) {
			errors.rejectValue("file", null, "Por favor, seleccione una imagen!");
			return;
		}

	}

}
