package com.inventory.administration.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inventory.administration.DTO.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where p.name=?1")
    public Optional<Product> findProductByName(String name);

}
