package com.Ecommerce.Learning.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_modifier_option_image")
public class ItemModifierOptionImage {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "image_link", columnDefinition = "TEXT")
  private String imageLink;

  @Column(name = "display_order")
  private Integer displayOrder;

  @ManyToOne(fetch = FetchType.LAZY)
  // name refers to the field name of the foreign key in the database, in this case, in the item_modifier_option_image table, item_id is the foreign key field name
  @JoinColumn(name = "item_id", nullable = false)
  // https://stackoverflow.com/questions/31319358/jsonmanagedreference-vs-jsonbackreference for reference
  // Prevents infinite recurion when Item has ItemImages and ItemImages have Item forever
  @JsonBackReference
  private Item item;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "modifier_option_id", nullable = false)
  @JsonBackReference
  private ItemModifierOption itemModifierOption;

  public ItemModifierOptionImage() { }

  public ItemModifierOptionImage(Long id, String imageLink, Integer displayOrder, Item item, ItemModifierOption itemModifierOption) {
    this.id = id;
    this.imageLink = imageLink;
    this.displayOrder = displayOrder;
    this.item = item;
    this.itemModifierOption = itemModifierOption;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
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

  public Item getItem() {
    return this.item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public ItemModifierOption getItemModifierOption() {
    return this.itemModifierOption;
  }

  public void setItemModifierOption(ItemModifierOption itemModifierOption) {
    this.itemModifierOption = itemModifierOption;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", imageLink='" + getImageLink() + "'" +
      ", displayOrder='" + getDisplayOrder() + "'" +
      ", item='" + getItem() + "'" +
      ", itemModifierOption='" + getItemModifierOption() + "'" +
      "}";
  }
}
