package com.Ecommerce.Learning.DTOs.Item;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class ItemModifierDTOWithoutRelationship {
  private long id;
  private String name;
  private Integer displayOrder;
}
