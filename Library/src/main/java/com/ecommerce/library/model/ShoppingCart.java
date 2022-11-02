package com.ecommerce.library.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_cart_id")
    private Long id;
    
    private int totalItems;
    
    private double totalPrices;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItem;

	public ShoppingCart() {
		
	}

	public ShoppingCart(Long id, int totalItems, double totalPrices, Customer customer, Set<CartItem> cartItem) {
		this.id = id;
		this.totalItems = totalItems;
		this.totalPrices = totalPrices;
		this.customer = customer;
		this.cartItem = cartItem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public double getTotalPrices() {
		return totalPrices;
	}

	public void setTotalPrices(double totalPrices) {
		this.totalPrices = totalPrices;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<CartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(Set<CartItem> cartItem) {
		this.cartItem = cartItem;
	}
}