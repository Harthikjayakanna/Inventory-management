package com.inventory.administration.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.administration.DTO.Items;

public interface ItemsRepository extends JpaRepository<Items,Integer> {
    
}
