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
import lombok.Data;

@Entity
@Table(name = "item_modifier_option")
@Data
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
}
