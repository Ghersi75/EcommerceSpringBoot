package com.Ecommerce.Learning.DTOs.Item;

import java.util.List;

import com.Ecommerce.Learning.Models.ItemModifierOption;

public class ItemModifierDTO extends ItemModifierDTOWithoutRelationship {
  private List<ItemModifierOption> itemModifierOptions;

  public ItemModifierDTO(long id, String name, Integer displayOrder, List<ItemModifierOption> itemModifierOptions) {
    super(id, name, displayOrder);
    this.itemModifierOptions = itemModifierOptions;
  }

  public List<ItemModifierOption> getItemModifierOptions() {
    return this.itemModifierOptions;
  }

  public void setItemModifierOptions(List<ItemModifierOption> itemModifierOptions) {
    this.itemModifierOptions = itemModifierOptions;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", name='" + getName() + "'" +
      ", displayOrder='" + getDisplayOrder() + "'" +
      " itemModifierOptions='" + getItemModifierOptions() + "'" +
      "}";
  }
}
