package net.py.backendshopping.dto;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user_detail")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Ingrese su primer nombre")
	@Column(name = "first_name")
	private String firstName;
	@NotBlank(message = "Ingrese su segundo nombre")
	@Column(name = "last_name")
	private String lastName;
	@NotBlank(message = "Ingrese su correo electrónico")
	private String email;
	@NotBlank(message = "Ingrese su número de teléfono")
	@Column(name = "contact_number")
	private String contactNumber;
	@NotBlank(message = "Ingrese su contraseña")
	private String password;
	@Transient
	private String confirmPassword;
	
	private String role;
	private boolean enabled = true;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", role=" + role + ", enabled=" + enabled + "]";
	}
	
	@OneToOne(mappedBy="userDTO", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Cart cartDTO;


	public Cart getCartDTO() {
		return cartDTO;
	}
	public void setCartDTO(Cart cartDTO) {
		this.cartDTO = cartDTO;
	}
	
}
