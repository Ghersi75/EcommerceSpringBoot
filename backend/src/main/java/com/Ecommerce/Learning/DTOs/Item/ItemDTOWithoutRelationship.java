package com.Ecommerce.Learning.DTOs.Item;

import com.Ecommerce.Learning.Models.Item;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemDTOWithoutRelationship {
  private long id;
  private String title;
  private String description;
  private int displayOrder;
  private int price;
  private Integer discountPrice;
  private String thumbnailImageLink;

  // Used for repository query that takes Item directly as parameter
  public ItemDTOWithoutRelationship(Item item) {
    this.id = item.getId();
    this.title = item.getTitle();
    this.description = item.getDescription();
    this.displayOrder = item.getDisplayOrder();
    this.price = item.getPrice();
    this.discountPrice = item.getDiscountPrice();
    this.thumbnailImageLink = item.getThumbnailImageLink();
  }
}
