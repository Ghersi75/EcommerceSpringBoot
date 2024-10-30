package com.Ecommerce.Learning.DTOs.Item;

import java.util.List;

import com.Ecommerce.Learning.Models.ItemModifierOptionImage;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ItemModifierOptionDTO extends ItemModifierOptionDTOWithoutRelationship {
  private List<ItemModifierOptionImage> ItemModifierOptionImages;


  public ItemModifierOptionDTO(long id, String name, String thumbnailImageLink, Integer displayOrder, List<ItemModifierOptionImage> ItemModifierOptionImages) {
    super(id, name, thumbnailImageLink, displayOrder);
    this.ItemModifierOptionImages = ItemModifierOptionImages;
  }
}
