package com.Ecommerce.Learning.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// https://www.baeldung.com/jpa-join-column for reference
@Entity
@Table(name = "store_item")
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String description;

  // mappedBy refers to the Item object in the ItemImage class
  @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
  // https://stackoverflow.com/questions/31319358/jsonmanagedreference-vs-jsonbackreference for reference
  // Prevents infinite recurion when Item has ItemImages and ItemImages have Item forever
  @JsonManagedReference
  private List<ItemModifier> itemModifiers;

  private int displayOrder;

  public Item() { }

  public Item(Long id, String title, String description, List<ItemModifier> itemModifiers, int displayOrder) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.itemModifiers = itemModifiers;
    this.displayOrder = displayOrder;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
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

  public List<ItemModifier> getItemModifiers() {
    return this.itemModifiers;
  }

  public void setItemModifiers(List<ItemModifier> itemModifiers) {
    this.itemModifiers = itemModifiers;
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
      ", itemModifiers='" + getItemModifiers() + "'" +
      ", displayOrder='" + getDisplayOrder() + "'" +
      "}";
  }

}
