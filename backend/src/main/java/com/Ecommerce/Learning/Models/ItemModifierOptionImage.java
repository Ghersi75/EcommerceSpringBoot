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
import lombok.Data;

@Entity
@Table(name = "item_modifier_option_image")
@Data
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
}
