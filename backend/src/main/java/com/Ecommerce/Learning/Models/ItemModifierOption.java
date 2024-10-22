package com.Ecommerce.Learning.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_modifier_option")
public class ItemModifierOption {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

  @Column(name = "thumbnail_image_link", columnDefinition = "TEXT")
  private String thumbnailImageLink;

  @Column(name = "display_order")
  private Integer displayOrder;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "modifier_id", nullable = false)
  @JsonBackReference
  private ItemModifier itemModifier;

  @OneToMany(mappedBy = "itemModifierOption", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private List<ItemModifierOptionImage> itemModifierOptionImages;

  public ItemModifierOption() { }

  public ItemModifierOption(long id, String name, String thumbnailImageLink, Integer displayOrder, ItemModifier itemModifier, List<ItemModifierOptionImage> itemModifierOptionImages) {
    this.id = id;
    this.name = name;
    this.thumbnailImageLink = thumbnailImageLink;
    this.displayOrder = displayOrder;
    this.itemModifier = itemModifier;
    this.itemModifierOptionImages = itemModifierOptionImages;
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

  public ItemModifier getItemModifier() {
    return this.itemModifier;
  }

  public void setItemModifier(ItemModifier itemModifier) {
    this.itemModifier = itemModifier;
  }

  public List<ItemModifierOptionImage> getItemModifierOptionImages() {
    return this.itemModifierOptionImages;
  }

  public void setItemModifierOptionImages(List<ItemModifierOptionImage> itemModifierOptionImages) {
    this.itemModifierOptionImages = itemModifierOptionImages;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", name='" + getName() + "'" +
      ", thumbnailImageLink='" + getThumbnailImageLink() + "'" +
      ", displayOrder='" + getDisplayOrder() + "'" +
      ", itemModifier='" + getItemModifier() + "'" +
      ", itemModifierOptionImages='" + getItemModifierOptionImages() + "'" +
      "}";
  }
}
