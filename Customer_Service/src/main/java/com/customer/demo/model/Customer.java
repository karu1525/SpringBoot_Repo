package com.customer.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="customer")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 6796098319658059439L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty(message = "The above field must not be blank.")
	private String firstName;
	
	@NotEmpty(message = "The above field must not be blank.")
	private String lastName;
	
	@NotEmpty(message = "The above field must not be blank.")
	private String email;
	
	public Customer() {
		
	}

	public Customer(Long custId, @NotEmpty(message = "The above field must not be blank.") String firstName,
			@NotEmpty(message = "The above field must not be blank.") String lastName,
			@NotEmpty(message = "The above field must not be blank.") String email) {
		
		this.id = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getCustId() {
		return id;
	}

	public void setCustId(Long custId) {
		this.id = custId;
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

	@Override
	public String toString() {
		return "Customer [custId=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}
	
	
	
	
}
