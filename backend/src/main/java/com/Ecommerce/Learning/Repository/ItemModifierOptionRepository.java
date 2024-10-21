package com.Ecommerce.Learning.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.Learning.Models.ItemModifierOption;

public interface ItemModifierOptionRepository extends JpaRepository<ItemModifierOption, Long> {
  
}
