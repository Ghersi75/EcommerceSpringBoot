package com.Ecommerce.Learning.DTOs.Item;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemModifierOptionDTOWithoutRelationship {
  private long id;
  private String name;
  private String thumbnailImageLink;
  private Integer displayOrder;
}
