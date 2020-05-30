package net.py.backendshopping.dto;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "cart_line")
public class CartLine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Product productDTO;
	@Column(name = "cart_id")
	private int cartId;	
	@Column(name = "product_count")
	private int productCount;
	@Column(name = "is_available")
	private boolean available = true;
	@Column(name = "buying_price")
	private double buyingPrice;
	private double total;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(Product productDTO) {
		this.productDTO = productDTO;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public double getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	

}
