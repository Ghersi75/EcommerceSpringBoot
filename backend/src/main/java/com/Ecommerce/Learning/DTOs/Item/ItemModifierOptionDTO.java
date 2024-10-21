package com.Ecommerce.Learning.DTOs.Item;

import java.util.List;

import com.Ecommerce.Learning.Models.ItemModifierOptionImage;

public class ItemModifierOptionDTO extends ItemModifierOptionDTOWithoutRelationship {
  private List<ItemModifierOptionImage> ItemModifierOptionImages;


  public ItemModifierOptionDTO(long id, String name, String thumbnailImageLink, Integer displayOrder, List<ItemModifierOptionImage> ItemModifierOptionImages) {
    super(id, name, thumbnailImageLink, displayOrder);
    this.ItemModifierOptionImages = ItemModifierOptionImages;
  }

  public List<ItemModifierOptionImage> getItemModifierOptionImages() {
    return this.ItemModifierOptionImages;
  }

  public void setItemModifierOptionImages(List<ItemModifierOptionImage> ItemModifierOptionImages) {
    this.ItemModifierOptionImages = ItemModifierOptionImages;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", name='" + getName() + "'" +
      ", thumbnailImageLink='" + getThumbnailImageLink() + "'" +
      ", displayOrder='" + getDisplayOrder() + "'" +
      " ItemModifierOptionImages='" + getItemModifierOptionImages() + "'" +
      "}";
  }
}
