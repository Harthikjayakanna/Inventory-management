package com.inventory.administration.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.administration.DTO.Product;
import com.inventory.administration.DTO.ResponseStructure;
import com.inventory.administration.Service.ProductService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/product")
    public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int id) {
        return service.deleteProduct(id);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ResponseStructure<Product>> getProductById(@PathVariable int id) {
        return service.getById(id);
    }

    @GetMapping("/allProduct")
    public ResponseEntity<ResponseStructure<List<Product>>> getMethodName() {
        return service.getAllProduct();
    }

}
