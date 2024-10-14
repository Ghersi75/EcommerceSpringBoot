package com.Ecommerce.Learning.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.Learning.Models.Item;
import com.Ecommerce.Learning.Services.ItemService;

@RestController
@RequestMapping("/items")
// Without this, backend will no allow api calls from frontend during development
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {
  private final ItemService itemService;

  public ItemController(ItemService itemService) {
    this.itemService = itemService;
  }

  @GetMapping("/{item_id}")
  public Item GetItemByIdHandler(@PathVariable Long item_id) {
    return this.itemService.GetItemById(item_id);
  }

  @GetMapping("")
  public List<Item> GetAllItemsHandler() {
    return this.itemService.GetAllItems();
  }
}
