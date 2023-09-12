package com.kennylam.adventureexchange.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@NotEmpty(message="First name is required")
	@Size(min=3, max=200, message="Username must be AT LEAST 3 characters!")
	private String firstName;
	
	@NotBlank
	@NotEmpty(message="Last name is required")
	@Size(min=3, max=200, message="Username must be AT LEAST 3 characters!")
	private String lastName;
	
	@NotBlank
	@NotEmpty(message="Email is required!")
	@Email(message="Please enter a valid Email Address!")
	private String email;
	
	@NotBlank
	@NotEmpty(message="Password is required!")
	@Size(min=8, max=200, message="Password must be AT LEAST 8 characters!")
	private String password;
	
	@Transient
	@NotBlank
	@NotEmpty(message="Please confirm your password!")
	@Size(min=8, max=200, message="Confirm Password must be AT LEAST 8 characters!")
	private String confirm;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="YYYY-MM-dd")
	private Date createdAt;
	
	
	@DateTimeFormat(pattern="YYYY-MM-dd")
	private Date updatedAt;
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<Equipment> equipment;
	
	public User() {}
	
		
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getlastName() {
		return lastName;
	}
	
	public void setlastName(String lastName) {
		this.lastName = lastName;
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

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Equipment> getGuests() {
		return equipment;
	}

	public void setGuests(List<Equipment> guests) {
		this.equipment = guests;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	
}
	
