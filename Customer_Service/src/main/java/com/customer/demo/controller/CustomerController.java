package com.customer.demo.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.demo.model.Customer;
import com.customer.demo.service.CustomerService;

@RestController
@RequestMapping("/shop")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
//save the Customer record
	@PostMapping("/customer")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return customerService.save(customer);
	
	}
	
//Get All the Customer Record
	@GetMapping("/customer")
	public List<Customer> getAllCustomer() {
			return customerService.findAll();
	}
	
//	Get the Customer record by id
	
	@GetMapping("/customer/{id}")
	public ResponseEntity <Customer> getCustById(@PathVariable(value="id") Long customerId) {
		
		Customer cust = customerService.findById(customerId);
		if(cust==null) {
			
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(cust); 
	}
	
//	update the Customer data 
	
	@PutMapping("/customer/{id}")
	public ResponseEntity <Customer> updateCustomer(@PathVariable(value="id") Long id, @Valid @RequestBody Customer customerDetails){
		
		Customer customer = customerService.findById(id);
		
		if(customer==null) {
			return ResponseEntity.notFound().build();
		}
		
		customer.setFirstName(customerDetails.getFirstName());
		customer.setLastName(customerDetails.getLastName());
		customer.setEmail(customerDetails.getEmail());
		
		Customer customerUpdate =customerService.save(customer);
		return ResponseEntity.ok().body(customerUpdate);
	}
	
//	Delete the customer data
	@DeleteMapping("/customer/{id}")
	public ResponseEntity <Customer> deleteCustomer(@PathVariable(value="id")Long custId){
		
		Customer customerUpdate = customerService.findById(custId);
		if(customerUpdate==null) {
			return ResponseEntity.notFound().build();
		}
		customerService.delete(customerUpdate);
		return ResponseEntity.ok().build();
	}
	
	

}
