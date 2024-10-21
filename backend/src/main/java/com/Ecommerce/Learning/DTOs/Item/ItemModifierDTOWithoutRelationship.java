package com.Ecommerce.Learning.DTOs.Item;

public class ItemModifierDTOWithoutRelationship {
  private long id;
  private String name;
  private Integer displayOrder;

  public ItemModifierDTOWithoutRelationship(long id, String name, Integer displayOrder) {
    this.id = id;
    this.name = name;
    this.displayOrder = displayOrder;
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getDisplayOrder() {
    return this.displayOrder;
  }

  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", name='" + getName() + "'" +
      ", displayOrder='" + getDisplayOrder() + "'" +
      "}";
  }
}
