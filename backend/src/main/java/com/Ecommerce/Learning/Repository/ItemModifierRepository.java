package com.Ecommerce.Learning.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.Learning.Models.ItemModifier;

public interface ItemModifierRepository extends JpaRepository<ItemModifier, Long> {
  
}
