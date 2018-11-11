package com.item.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.item.demo.model.Item;

@Repository
public interface ItemRepository  extends JpaRepository<Item, Long>{

}
