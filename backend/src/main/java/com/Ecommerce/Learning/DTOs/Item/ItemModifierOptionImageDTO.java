package com.Ecommerce.Learning.DTOs.Item;

public class ItemModifierOptionImageDTO {
  private long id;
  private String imageLink;
  private Integer displayOrder;

  public ItemModifierOptionImageDTO(long id, String imageLink, Integer displayOrder) {
    this.id = id;
    this.imageLink = imageLink;
    this.displayOrder = displayOrder;
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getImageLink() {
    return this.imageLink;
  }

  public void setImageLink(String imageLink) {
    this.imageLink = imageLink;
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
      ", imageLink='" + getImageLink() + "'" +
      ", displayOrder='" + getDisplayOrder() + "'" +
      "}";
  }
}
