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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;


@RestController
@RequestMapping("/shop")
@Api(value="/shop", description="Operations pertaining to customer in Online Store" ,produces ="application/json")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
//save the Customer record
	@PostMapping("/customer")
	@ApiOperation(value = "Added the information of Customer", response = Iterable.class, consumes="application/json", produces="application/json")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully inserted the customer data"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return customerService.save(customer);
	
	}
	
//Get All the Customer Record
	@GetMapping("/customer")
	@ApiOperation(value = "Get the information of the All Customer", response = Iterable.class, consumes="application/json", produces="application/json")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved the the customer data"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public List<Customer> getAllCustomer() {
			return customerService.findAll();
	}
	
//	Get the Customer record by id
	
	@GetMapping("/customer/{id}")
	@ApiOperation(value = "Get the information of the Customer by id", response = Iterable.class, consumes="application/json", produces="application/json")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved the the customer data for perticular id "),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity <Customer> getCustById(@PathVariable(value="id") Long customerId) {
		
		Customer cust = customerService.findById(customerId);
		if(cust==null) {
			
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(cust); 
	}
	
//	update the Customer data 
	
	@PutMapping("/customer/{id}")
	@ApiOperation(value = "Updated the information of the  Customer", response = Iterable.class, consumes="application/json", produces="application/json")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully Updated the the customer data"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
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
	@ApiOperation(value = "Deleted the information of the  Customer", response = Iterable.class, consumes="application/json", produces="application/json")
	@ApiResponses(value = {
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity <Customer> deleteCustomer(@PathVariable(value="id")Long custId){
		
		Customer customerUpdate = customerService.findById(custId);
		if(customerUpdate==null) {
			return ResponseEntity.notFound().build();
		}
		customerService.delete(customerUpdate);
		return ResponseEntity.ok().build();
	}
	
	

}
