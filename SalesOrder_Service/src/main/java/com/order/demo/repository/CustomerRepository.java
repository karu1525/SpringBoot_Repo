package com.order.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.demo.model.Customer;


@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long>{

}
