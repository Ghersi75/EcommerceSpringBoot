package com.Ecommerce.Learning.DTOs.Item;

import java.util.List;

public class ItemDTO extends ItemDTOWithoutRelationship {
  private List<ItemModifierDTO> itemModifiers;

  public ItemDTO(long id, String title, String description, int displayOrder, List<ItemModifierDTO> modifiers) {
    super(id, title, description, displayOrder);
    this.itemModifiers = modifiers;
  }

  public List<ItemModifierDTO> getItemModifiers() {
    return this.itemModifiers;
  }

  public void setItemModifiers(List<ItemModifierDTO> itemModifiers) {
    this.itemModifiers = itemModifiers;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", title='" + getTitle() + "'" +
      ", description='" + getDescription() + "'" +
      ", displayOrder='" + getDisplayOrder() + "'" +
      " itemModifiers='" + getItemModifiers() + "'" +
      "}";
  }

}