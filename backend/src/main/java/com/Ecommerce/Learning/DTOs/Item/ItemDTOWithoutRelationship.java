package com.Ecommerce.Learning.DTOs.Item;

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
}
