package com.order.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.order.demo.model.Sales;
import com.order.demo.repository.SalesOrderRepository;

@Service
public class SalesOrderService {
	
	@Autowired
	private SalesOrderRepository saleOrderRepository;
	
	public List<Sales> all(){
		
		return saleOrderRepository.findAll();
	} 
	
	public Sales save(Sales salesItem) {
		
		return saleOrderRepository.save(salesItem);
	}
	
	public Sales getSalesItem(Long custId) {
		return saleOrderRepository.getOne(custId);
		
	}
	
	public void delete(Long custId) {
		saleOrderRepository.deleteById(custId);		
	}
	
//	to delete by object
	public void delete(Sales salesItem) {
		saleOrderRepository.delete(salesItem);
	}
}
