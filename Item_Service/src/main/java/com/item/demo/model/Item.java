package com.item.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Item")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
 /*
  * problem with lazy loading via the hibernate proxy object. Got around it by annotating the class having lazy loaded private properties with:

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	I assume you can add the properties on your proxy object that breaks the JSON serialization to that annotation.

	The problem is that entities are loaded lazily and serialization happens before they get loaded fully.
	
	*/
public class Item implements Serializable{
	
	 private static final long serialVersionUID = 6796098319658059439L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	//@NotBlank
	@NotEmpty(message = "The above field must not be blank.")
	private String name;
	
	//@NotBlank
	@NotNull(message = "The above field must not be blank.")
	private double price;
	
	//@NotBlank
	@NotEmpty(message = "The above field must not be blank.")
	private String description;

	public Item() {
		
	}
	
	public Item(long id, @NotBlank String name, @NotBlank double price, @NotBlank String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + "]";
	}
	
	
	

}
