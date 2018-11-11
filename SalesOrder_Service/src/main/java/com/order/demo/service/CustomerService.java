package com.order.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.demo.model.Customer;
import com.order.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer save(Customer customer) {
		
		return customerRepository.save(customer);
		
		}
	
	
}
