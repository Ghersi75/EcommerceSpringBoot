package com.Ecommerce.Learning.DTOs.Item;

import java.util.List;

import com.Ecommerce.Learning.Models.ItemModifierOption;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ItemModifierDTO extends ItemModifierDTOWithoutRelationship {
  private List<ItemModifierOption> itemModifierOptions;

  public ItemModifierDTO(long id, String name, Integer displayOrder, List<ItemModifierOption> itemModifierOptions) {
    super(id, name, displayOrder);
    this.itemModifierOptions = itemModifierOptions;
  }
}
