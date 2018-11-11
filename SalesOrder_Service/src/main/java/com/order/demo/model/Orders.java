package com.order.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Orders")
public class Orders implements Serializable {
	
	private static final long serialVersionUID = 4L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "The above field must not be blank.")
	private String itemName;
	
	@NotNull(message = "The above field must not be blank.")
	private long quantity;
	
	@ManyToOne
	@JoinColumn(name = "id", referencedColumnName = "id" ,insertable = false, updatable = false)
	private Sales salesOrder ;
	
	public Orders() {
		
	}
	public Orders(long id, String itemName, long quantity, Sales salesOrder) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.quantity = quantity;
		this.salesOrder = salesOrder;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public long getQuantity() {
		return quantity;
	}


	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}


	public Sales getSalesOrder() {
		return salesOrder;
	}


	public void setSalesOrder(Sales salesOrder) {
		this.salesOrder = salesOrder;
	}


	@Override
	public String toString() {
		return "Orders [id=" + id + ", itemName=" + itemName + ", quantity=" + quantity + ", salesOrder=" + salesOrder
				+ "]";
	}
	
	
	
	
}
