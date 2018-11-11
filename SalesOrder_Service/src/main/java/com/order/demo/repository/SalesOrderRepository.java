package com.order.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.demo.model.Sales;

public interface SalesOrderRepository extends JpaRepository<Sales, Long> {

}
