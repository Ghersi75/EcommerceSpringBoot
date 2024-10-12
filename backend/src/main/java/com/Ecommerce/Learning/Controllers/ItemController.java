package com.Ecommerce.Learning.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.Learning.Models.Item;
import com.Ecommerce.Learning.Services.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
  private final ItemService itemService;

  @Autowired
  public ItemController(ItemService itemService) {
    this.itemService = itemService;
  }

  @GetMapping("/{item_id}")
  public Item GetItemById(Long item_id) {
    return this.itemService.GetItemById(item_id);
  }
}
