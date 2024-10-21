package com.Ecommerce.Learning.DTOs.Item;

public class ItemModifierOptionDTOWithoutRelationship {
  private long id;
  private String name;
  private String thumbnailImageLink;
  private Integer displayOrder;

  public ItemModifierOptionDTOWithoutRelationship(long id, String name, String thumbnailImageLink, Integer displayOrder) {
    this.id = id;
    this.name = name;
    this.thumbnailImageLink = thumbnailImageLink;
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

  public String getThumbnailImageLink() {
    return this.thumbnailImageLink;
  }

  public void setThumbnailImageLink(String thumbnailImageLink) {
    this.thumbnailImageLink = thumbnailImageLink;
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
      ", thumbnailImageLink='" + getThumbnailImageLink() + "'" +
      ", displayOrder='" + getDisplayOrder() + "'" +
      "}";
  }
}
