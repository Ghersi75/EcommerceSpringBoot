package com.Ecommerce.Learning.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.Learning.Models.Item;;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
