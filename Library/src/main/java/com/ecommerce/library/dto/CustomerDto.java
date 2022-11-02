package com.ecommerce.library.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerDto {

    @Pattern(regexp = "^[a-zA-Z ]{3,10}+$", message = "Invalid first name!(3-10 characters)")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z ]{3,10}+$", message = "Invalid last name!(3-10 characters)")
    private String lastName;

	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid email address!")
    private String username;

    @Size(min = 5, max = 15, message = "Invalid password!(5-15 characters)")
    private String password;

    private String repeatPassword;

    
	public CustomerDto() {
	
	}

	public CustomerDto(String firstName, String lastName, 
			String username, String password, String repeatPassword) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.repeatPassword = repeatPassword;
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

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
}
