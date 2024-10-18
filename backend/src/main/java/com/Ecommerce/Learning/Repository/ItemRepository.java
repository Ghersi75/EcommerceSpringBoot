package com.Ecommerce.Learning.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import com.Ecommerce.Learning.DTOs.TestDTO;
import com.Ecommerce.Learning.Models.Item;;

public interface ItemRepository extends JpaRepository<Item, Long> {

  @Query("SELECT new com.Ecommerce.Learning.DTOs.TestDTO(i.id, i.title, i.description) FROM Item i")
  List<TestDTO> GetAllItemsWithoutImages();
}
