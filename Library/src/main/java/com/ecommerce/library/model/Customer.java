package com.ecommerce.library.model;
  
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "customers", 
uniqueConstraints = @UniqueConstraint(columnNames = {"username", "image", "phone_number"}))
public class Customer {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    //@Pattern(regexp = "^[a-zA-Z ]{3,10}+$", message = "Invalid first name!(3-10 characters)")
    private String firstName;
   
    //@Pattern(regexp = "^[a-zA-Z ]{3,10}+$", message = "Invalid last name!(3-10 characters)")    
    private String lastName;
    
    //@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid email address!")
    private String username;
    
    //@Size(min = 5, max = 15, message = "Invalid password!(5-15 characters)")
    private String password;
    
    @Column(name = "phone_number")
    //@Pattern(regexp = "[6-9][0-9]{9}", message = "Invalid mobile number!")
    private String phoneNumber;
    
    //@Pattern(regexp = "^[a-zA-Z0-9 ]{5,60}+$", message = "Invalid Address!(5-60 characters)")
    private String address;
 
    //@Pattern(regexp = "^[a-zA-Z ]{3,30}+$", message = "Invalid Country!(3-30 characters)")
    private String country;

    //@Pattern(regexp = "^[a-zA-Z ]{3,30}+$", message = "Invalid City!(3-30 characters)")
    @Column(name = "city")
    private String city;
    
    @Lob
    @Column(name = "image", columnDefinition = "MEDIUMBLOB")
    private String image;

    @OneToOne(mappedBy = "customer")
    private ShoppingCart shoppingCart;
 
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
      
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable( name = "customers_roles",
            joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Collection<Role> roles;

    
	public Customer() {
		
	}

	public Customer(Long id, String firstName, String lastName, String username, 
			String password, String phoneNumber, String address, String country,
			String city, String image, ShoppingCart shoppingCart, 
			List<Order> orders, Collection<Role> roles) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.country = country;
		this.city = city;
		this.image = image;
		this.shoppingCart = shoppingCart;
		this.orders = orders;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}  
}