package com.ecommerce.library.dto;

public class CategoryDto {
	
    private Long categoryId;
    
    private String categoryName;
    
    private Long numberOfProduct;

    
	public CategoryDto() {
	
	}

	public CategoryDto(Long categoryId, String categoryName, Long numberOfProduct) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.numberOfProduct = numberOfProduct;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getNumberOfProduct() {
		return numberOfProduct;
	}

	public void setNumberOfProduct(Long numberOfProduct) {
		this.numberOfProduct = numberOfProduct;
	}
}
