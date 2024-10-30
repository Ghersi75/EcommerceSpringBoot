package com.Ecommerce.Learning.DTOs.Item;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemModifierOptionImageDTO {
  private long id;
  private String imageLink;
  private Integer displayOrder;
}
