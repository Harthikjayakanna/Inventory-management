package com.inventory.administration.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inventory.administration.DAO.ProductDao;
import com.inventory.administration.DTO.Product;
import com.inventory.administration.DTO.ResponseStructure;
import com.inventory.administration.Exception.IDnotFoundException;

@Service
public class ProductService {
    @Autowired
    private ProductDao dao;
    ResponseStructure<Product> rsProduct = new ResponseStructure<>();

    public ResponseEntity<ResponseStructure<Product>> saveProduct(Product p) {
        rsProduct.setData(dao.saveProduct(p));
        rsProduct.setMessage("Product have been added");
        rsProduct.setStatusCode(HttpStatus.CREATED.value());
        return new ResponseEntity<ResponseStructure<Product>>(rsProduct, HttpStatus.CREATED);
    }

    // Update
    public ResponseEntity<ResponseStructure<Product>> updateProduct(Product p) {
        rsProduct.setData(dao.updateProduct(p));
        rsProduct.setMessage("Product have been updated");
        rsProduct.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<ResponseStructure<Product>>(rsProduct, HttpStatus.OK);
    }

    // Find by ID
    public ResponseEntity<ResponseStructure<Product>> getById(int id) {
        Optional<Product> optProduct = dao.findbyId(id);
        if (optProduct.isPresent()) {
            rsProduct.setData(optProduct.get());
            rsProduct.setMessage("Product have been added");
            rsProduct.setStatusCode(HttpStatus.CREATED.value());
            return new ResponseEntity<ResponseStructure<Product>>(rsProduct, HttpStatus.CREATED);
        }
        throw new IDnotFoundException();
    }

    // Get all the product
    public ResponseEntity<ResponseStructure<List<Product>>> getAllProduct() {
        ResponseStructure<List<Product>> rsProduct = new ResponseStructure<>();
        rsProduct.setData(dao.getAllProduct());
        rsProduct.setMessage("All Products so far");
        rsProduct.setStatusCode(HttpStatus.FOUND.value());
        return new ResponseEntity<ResponseStructure<List<Product>>>(rsProduct, HttpStatus.FOUND);
    }

    // Delete the product
    public ResponseEntity<ResponseStructure<String>> deleteProduct(int id) {
        ResponseStructure<String> rsProduct = new ResponseStructure<>();
        Optional<Product> optProduct = dao.findbyId(id);
        if (optProduct.isPresent()) {
            dao.deleteproduct(optProduct.get());
            rsProduct.setData("Product has been deleted");
            rsProduct.setMessage("Id founded");
            rsProduct.setStatusCode(HttpStatus.FOUND.value());
            return new ResponseEntity<ResponseStructure<String>>(rsProduct, HttpStatus.FOUND);
        }
        throw new IDnotFoundException();
    }
}
