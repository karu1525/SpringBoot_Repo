package com.customer.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.demo.model.Customer;
import com.customer.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
//	Save the cutomer data
	public Customer save(Customer customer) {
		
		return customerRepository.save(customer);
	}
	
//	Search the customer data
	
	public List<Customer> findAll(){
		
		return customerRepository.findAll();
	}
	
//	Get the customer data by id
	
	public Customer findById(Long custId){
		return customerRepository.getOne(custId);
		 
	}
	
//	Delete  the customer data by object
	
	public void delete(Customer customer) {
		
		 customerRepository.delete(customer);
	}
	
//	Delete the customer data
	public void delete(Long custId) {
		
		 customerRepository.deleteById(custId);
	}

	
	
}
