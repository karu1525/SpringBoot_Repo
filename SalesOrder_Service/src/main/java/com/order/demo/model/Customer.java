package com.order.demo.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="customer_sos")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {
	
	@Id
	private long custId;
	
	@NotNull(message = "The above field must not be blank.")
	private String custEmail;
	
	@NotNull(message = "The above field must not be blank.")
	private String custFirstName;
	
	@NotNull(message = "The above field must not be blank.")
	private String custLastName;
	
	
	public Customer() {
		
	}
	
	public Customer(long custId, String custEmail, String custFirstName, String custLastName) {
		super();
		this.custId = custId;
		this.custEmail = custEmail;
		this.custFirstName = custFirstName;
		this.custLastName = custLastName;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustFirstName() {
		return custFirstName;
	}
	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}
	public String getCustLastName() {
		return custLastName;
	}
	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}
	
	
	

}
