package com.Ecommerce.Learning.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

// https://www.baeldung.com/jpa-join-column for reference
@Entity
@Table(name = "store_item")
@Data
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

  @Column(name = "display_order")
  private int displayOrder;

  private int price;

  @Column(name = "discount_price", nullable = true)
  private Integer discountPrice;

  @Column(name = "thumbnail_image_link")
  private String thumbnailImageLink;
}
