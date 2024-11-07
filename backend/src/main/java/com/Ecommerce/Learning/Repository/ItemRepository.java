package com.Ecommerce.Learning.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Ecommerce.Learning.DTOs.Item.ItemDTOWithoutRelationship;
import com.Ecommerce.Learning.Models.Item;;

public interface ItemRepository extends JpaRepository<Item, Long> {
  @Query("SELECT new com.Ecommerce.Learning.DTOs.Item.ItemDTOWithoutRelationship(i) FROM Item i")
  List<ItemDTOWithoutRelationship> findAllNotDetailed();
}
