package com.ecommerce.library.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "products", 
uniqueConstraints = @UniqueConstraint(columnNames = {"name", "image"}))
public class Product {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    
    @Pattern(regexp = "^[a-zA-Z0-9 ]{3,40}+$", message = "Invalid product name!(3-40 characters)")
    private String name;
    
    @Length(min = 3, max = 100, message = "Invalid product description!(3-300 characters)")
    private String description;
    
    private double costPrice;
    
    private double salePrice;
    
    private int currentQuantity;
    
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")		
    private Category category;
    
    private boolean is_deleted;
    
    private boolean is_activated;

	public Product() {
		
	}

	public Product(Long id, String name, String description, double costPrice, double salePrice, int currentQuantity,
			String image, Category category, boolean is_deleted, boolean is_activated) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.costPrice = costPrice;
		this.salePrice = salePrice;
		this.currentQuantity = currentQuantity;
		this.image = image;
		this.category = category;
		this.is_deleted = is_deleted;
		this.is_activated = is_activated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public int getCurrentQuantity() {
		return currentQuantity;
	}

	public void setCurrentQuantity(int currentQuantity) {
		this.currentQuantity = currentQuantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	public boolean isIs_activated() {
		return is_activated;
	}

	public void setIs_activated(boolean is_activated) {
		this.is_activated = is_activated;
	}

}