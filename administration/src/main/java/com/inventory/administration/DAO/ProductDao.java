package com.inventory.administration.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventory.administration.DTO.Product;
import com.inventory.administration.Repository.ProductRepository;

@Repository
public class ProductDao {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product p) {
        return repository.save(p);
    }

    public Product updateProduct(Product p) {
        return repository.save(p);
    }

    public Optional<Product> findbyId(int id) {
        return repository.findById(id);
    }

    public List<Product> getAllProduct() {
        return repository.findAll();
    }

    public void deleteproduct(Product p) {
        repository.delete(p);
    }

    public Optional<Product> findbyName(String name) {
        return repository.findProductByName(name);
    }

    public List<Product> getByIds(List<Integer> ids) {
        return repository.findAllById(ids);
    }

}
