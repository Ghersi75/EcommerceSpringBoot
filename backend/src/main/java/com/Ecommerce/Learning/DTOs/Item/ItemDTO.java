package com.Ecommerce.Learning.DTOs.Item;

import java.util.List;

public class ItemDTO extends ItemDTOWithoutRelationship {
  private List<ModifierDTO> modifiers;

  public ItemDTO(long id, String title, String description, int displayOrder, List<ModifierDTO> modifiers) {
    super(id, title, description, displayOrder);
    this.modifiers = modifiers;
  }

  public List<ModifierDTO> getModifiers() {
    return this.modifiers;
  }

  public void setModifiers(List<ModifierDTO> modifiers) {
    this.modifiers = modifiers;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", title='" + getTitle() + "'" +
      ", description='" + getDescription() + "'" +
      ", displayOrder='" + getDisplayOrder() + "'" +
      " modifiers='" + getModifiers() + "'" +
      "}";
  }
}