package net.py.backendshopping.dao;

import java.util.List;

import net.py.backendshopping.dto.Cart;
import net.py.backendshopping.dto.CartLine;
import net.py.backendshopping.dto.OrderDetail;

public interface CartLineDAO {
	public List<CartLine> list(int cartId);
	public CartLine get(int id);	
	public boolean add(CartLine cartLineDTO);
	public boolean update(CartLine cartLineDTO);
	public boolean remove(CartLine cartLineDTO);
	
	// fetch the CartLine based on cartId and productId
	public CartLine getByCartAndProduct(int cartId, int productId);		
		
	// updating the cart
	boolean updateCart(Cart cartDTO);
	
	// list of available cartLine
	public List<CartLine> listAvailable(int cartId);
	
	// adding order details
	boolean addOrderDetail(OrderDetail orderDetailDTO);
}
