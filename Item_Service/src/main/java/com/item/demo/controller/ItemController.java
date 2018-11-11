package com.item.demo.controller;

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

import com.item.demo.model.Item;
import com.item.demo.service.ItemService;

@RestController
@RequestMapping("/os")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
//	to save the item in Database 
	@PostMapping("/item")
	public Item createItem(@Valid @RequestBody Item item) {

		return itemService.save(item);
		
	}
	
//	get all Item
	@GetMapping("/item")
	public List<Item> getAllItem(){
		return itemService.findAll();
	}
	
//	get item by id
	@GetMapping("/item/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable(value="id") Long id){
		Item item = itemService.getItem(id);
		if(item==null) {
		
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(item);
	}
	
//	update and item by id 
	
	@PutMapping("/item/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable(value="id") Long id, @Valid @RequestBody Item itemDetails){
		Item item = itemService.getItem(id);
		if(item==null) {
			return ResponseEntity.notFound().build();
			
		}
		item.setName(itemDetails.getName());
		item.setPrice(itemDetails.getPrice());
		item.setDescription(itemDetails.getDescription());
		
		Item updateItem = itemService.save(item);
		return ResponseEntity.ok().body(updateItem);
			
	}
//	delete an items
	
	@DeleteMapping("/item/{id}")
	public ResponseEntity<Item>  deleteItem(@PathVariable(value="id") Long itemId) {
		
		Item item = itemService.getItem(itemId);
		if(item==null) {
			return ResponseEntity.notFound().build();
		}
		itemService.delete(item);
		return ResponseEntity.ok().build();
	}
	
}
