package net.py.backendshopping.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userDTO;
	@Column(name = "order_total")
	private double orderTotal;
	@ManyToOne
	private Address shipping;
	@ManyToOne
	private Address billing;
	@OneToMany(mappedBy="orderDetailDTO", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<OrderItem> orderItemsDTO = new ArrayList<>();
	@Column(name = "order_count")
	private int orderCount;
	@Column(name="order_date")
	private Date orderDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(User userDTO) {
		this.userDTO = userDTO;
	}
	public double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public Address getShipping() {
		return shipping;
	}
	public void setShipping(Address shipping) {
		this.shipping = shipping;
	}
	public Address getBilling() {
		return billing;
	}
	public void setBilling(Address billing) {
		this.billing = billing;
	}
	public List<OrderItem> getOrderItemsDTO() {
		return orderItemsDTO;
	}
	public void setOrderItemsDTO(List<OrderItem> orderItemsDTO) {
		this.orderItemsDTO = orderItemsDTO;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	
}
