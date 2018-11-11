package com.order.demo.controller;

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

import com.order.demo.model.Sales;
import com.order.demo.service.SalesOrderService;

@RestController
@RequestMapping("/sos")
public class ServiceOrderController {
	
	@Autowired
	private SalesOrderService salesOrderService ;
	
	@GetMapping("/salesOrderAll")
	public List<Sales> getAll() {
		
		return salesOrderService.all();
	}
	
	@GetMapping("/salesOrder/{id}")
	public ResponseEntity getById(@PathVariable(value="id") Long id){
		
		Sales sales = salesOrderService.getSalesItem(id);
		if(sales==null) {
		
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(sales);
	}
	
	@PostMapping("/salesOrder/")
	public Sales addSalesOrder(@Valid @RequestBody Sales salesItem) {
		
		return salesOrderService.save(salesItem);
	}
	
	@PutMapping("/salesOrder/{id}")
	public ResponseEntity updateSalesOrder(@PathVariable(value="id") Long id, @Valid @RequestBody Sales salesDetails) {
		Sales sales = salesOrderService.getSalesItem(id);
		if(sales==null) {
			ResponseEntity.notFound().build();
			
		}
		
		sales.setOrderDate(salesDetails.getOrderDate());
		sales.setOrderDesc(salesDetails.getOrderDesc());
		sales.setPrice(salesDetails.getPrice());
		sales.setCustId(salesDetails.getCustId());
		
		Sales updateItem = salesOrderService.save(sales);
		return ResponseEntity.ok().body(updateItem);
		
	}
	
	@DeleteMapping("/salesOrder/{id}")
	public ResponseEntity<Sales> deleteSales(@PathVariable(value="id") Long salesId) {
		
		Sales sales =salesOrderService.getSalesItem(salesId);
		if(sales==null) {
			return ResponseEntity.notFound().build();
		}
		salesOrderService.delete(sales);
		return ResponseEntity.ok().build();
	}
	
	
	
}
