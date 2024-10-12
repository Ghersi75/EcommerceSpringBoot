package com.Ecommerce.Learning.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.Learning.Models.Item;
import com.Ecommerce.Learning.Repository.ItemRepository;

@Service
public class ItemService {
  private ItemRepository itemRepository;

  @Autowired
  public ItemService(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  public Item GetItemById(Long id) {
    return this.itemRepository.findById(id).orElse(null);
  }
}
