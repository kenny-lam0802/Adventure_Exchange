package com.kennylam.adventureexchange.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class LoginUser {
	
	@Email(message= "Please enter a vaild email")
	@NotEmpty(message="Email is required!")
	@NotBlank(message="Email is required!")
	private String email;
	
	@NotEmpty(message="Password is required")
	@NotBlank(message="Password is required")
	private String password;
	
	public LoginUser() {}

	public LoginUser(
			@Email(message = "Please enter a vaild email") @NotEmpty(message = "Email is required!") @NotBlank(message = "Email is required!") String email,
			@NotEmpty(message = "Password is required") @NotBlank(message = "Password is required") String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
