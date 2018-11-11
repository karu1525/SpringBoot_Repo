package com.item.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.demo.model.Item;
import com.item.demo.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
  private ItemRepository itemRepository ;
	
	
//	to Save the Item 
	public Item save(Item item) {
		return itemRepository.save(item);
	}
	
//	to search all the item
	public List<Item> findAll(){
		return itemRepository.findAll();
	}
	
//	to  get or update the item 
	public Item getItem(Long custId) {
		return itemRepository.getOne(custId);
	}
	
//	to delete the item by object
	public void delete(Item item) {
		 itemRepository.delete(item);
	}
	
//	to delete the item by id
	public void delete(Long custId) {
		itemRepository.deleteById(custId);
		
	}
}
