package com.order.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="SOS")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Sales implements  Serializable {

	
	private static final long serialVersionUID = 6L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "The above field must not be blank.")
	private long custId;
	
	@NotNull(message = "The above field must not be blank.")
	private Date orderDate;
	
	@NotNull(message = "The above field must not be blank.")
	private String orderDesc;
	
	@NotNull(message = "The above field must not be blank.")
	private double price;
	
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "salesOrder")
	private List<Orders> orderItems;

	public Sales() {
		
	}
	public Sales(long id, long custId, Date orderDate, String orderDesc, double price) {
	
		this.id = id;
		this.custId = custId;
		this.orderDate = orderDate;
		this.orderDesc = orderDesc;
		this.price = price;
	}

		
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public long getCustId() {
		return custId;
	}



	public void setCustId(long custId) {
		this.custId = custId;
	}



	public Date getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}



	public String getOrderDesc() {
		return orderDesc;
	}



	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}
	
	public List<Orders> getOrderItems() {
		return orderItems;
	}

	public void setOrderItem(List<Orders> orderItems) {
		this.orderItems = orderItems;
		this.orderItems.forEach(orderItem -> orderItem.setSalesOrder(this));
	}
	
	@Override
	public String toString() {
		return "Sales [id=" + id + ", custId=" + custId + ", orderDate=" + orderDate + ", orderDesc=" + orderDesc
				+ ", price=" + price + "]";
	}


	
}
