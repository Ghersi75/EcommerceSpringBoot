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
@Table(name = "item_modifier")
public class ItemModifier {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

  @Column(name = "display_order")
  private Integer displayOrder;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "item_id", nullable = false)
  @JsonBackReference
  private Item item;

  @OneToMany(mappedBy = "itemModifier", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private List<ItemModifierOption> itemModifierOptions;

  public ItemModifier() { }

  public ItemModifier(long id, String name, Integer displayOrder, Item item, List<ItemModifierOption> itemModifierOptions) {
    this.id = id;
    this.name = name;
    this.displayOrder = displayOrder;
    this.item = item;
    this.itemModifierOptions = itemModifierOptions;
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

  public Item getItem() {
    return this.item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public List<ItemModifierOption> getItemModifierOptions() {
    return this.itemModifierOptions;
  }

  public void setItemModifierOptions(List<ItemModifierOption> itemModifierOptions) {
    this.itemModifierOptions = itemModifierOptions;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", name='" + getName() + "'" +
      ", displayOrder='" + getDisplayOrder() + "'" +
      ", item='" + getItem() + "'" +
      ", itemModifierOptions='" + getItemModifierOptions() + "'" +
      "}";
  }
}
