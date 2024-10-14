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

// https://www.baeldung.com/jpa-join-column for reference
@Entity
@Table(name = "store_item_image")
public class ItemImage {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "image_link")
  private String imageLink;

  @Column(name = "display_order")
  private Integer displayOrder;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "store_item_id", nullable = false)
  // https://stackoverflow.com/questions/31319358/jsonmanagedreference-vs-jsonbackreference for reference
  // Prevents infinite recurion when Item has ItemImages and ItemImages have Item forever
  @JsonBackReference
  private Item item;

  public ItemImage() { }

  public ItemImage(Long id, String imageLink, Integer displayOrder, Item item) {
    this.id = id;
    this.imageLink = imageLink;
    this.displayOrder = displayOrder;
    this.item = item;
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

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", imageLink='" + getImageLink() + "'" +
      ", displayOrder='" + getDisplayOrder() + "'" +
      ", item='" + getItem() + "'" +
      "}";
  }
}
