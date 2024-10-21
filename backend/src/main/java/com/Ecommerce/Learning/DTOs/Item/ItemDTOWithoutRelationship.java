package com.Ecommerce.Learning.DTOs.Item;

public class ItemDTOWithoutRelationship {
  private long id;
  private String title;
  private String description;
  private int displayOrder;

  public ItemDTOWithoutRelationship(long id, String title, String description, int displayOrder) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.displayOrder = displayOrder;
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getDisplayOrder() {
    return this.displayOrder;
  }

  public void setDisplayOrder(int displayOrder) {
    this.displayOrder = displayOrder;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", title='" + getTitle() + "'" +
      ", description='" + getDescription() + "'" +
      ", displayOrder='" + getDisplayOrder() + "'" +
      "}";
  }

}
