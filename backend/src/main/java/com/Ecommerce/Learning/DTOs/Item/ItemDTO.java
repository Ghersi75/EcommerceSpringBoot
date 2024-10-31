package com.Ecommerce.Learning.DTOs.Item;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ItemDTO extends ItemDTOWithoutRelationship {
  private List<ItemModifierDTO> itemModifiers;

  public ItemDTO(long id, String title, String description, int displayOrder, int price, int discountPrice, String thumbnailImageLink, List<ItemModifierDTO> modifiers) {
    super(id, title, description, displayOrder, price, discountPrice, thumbnailImageLink);
    this.itemModifiers = modifiers;
  }
}