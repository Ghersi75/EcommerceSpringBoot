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

// https://www.baeldung.com/jpa-join-column for reference
@Entity
@Table(name = "store_item_image")
@Data
public class ItemImage {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "image_link", columnDefinition = "TEXT")
  private String imageLink;

  @Column(name = "display_order")
  private Integer displayOrder;

  @ManyToOne(fetch = FetchType.LAZY)
  // name refers to the field name of the foreign key in the database, in this case, in the store_item_image table, store_item_id is the foreign key field name
  @JoinColumn(name = "store_item_id", nullable = false)
  // https://stackoverflow.com/questions/31319358/jsonmanagedreference-vs-jsonbackreference for reference
  // Prevents infinite recurion when Item has ItemImages and ItemImages have Item forever
  @JsonBackReference
  private Item item;
}
