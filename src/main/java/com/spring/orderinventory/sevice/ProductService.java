package com.spring.orderinventory.sevice;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.orderinventory.Exception.InvalidProductDataException;
import com.spring.orderinventory.dto.ResponseStructure;
import com.spring.orderinventory.entity.Product;
import com.spring.orderinventory.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
    private ProductRepository productRepository;

    public ResponseEntity<ResponseStructure<Integer>> addProductsInBulk(List<Product> products) {
        ResponseStructure<Integer> responseStructure = new ResponseStructure<>();
        List<Integer> addedProductIds = new ArrayList<>();
        
        try {
            // Simulating data validation, you can add more validations as needed
            if (products == null || products.isEmpty()) {
                throw new InvalidProductDataException("Product data is empty or invalid.");
            }

            for (Product product : products) {
                Product savedProduct = productRepository.save(product);
                addedProductIds.add(savedProduct.getProductId());
            }
            
            responseStructure.setStatusCode(HttpStatus.OK.value());
            responseStructure.setMessage("Products added successfully.");
            responseStructure.setData(addedProductIds);
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        } catch (InvalidProductDataException e) {
            responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
            responseStructure.setMessage(e.getMessage());
            responseStructure.setData(new ArrayList<>());
            return new ResponseEntity<>(responseStructure, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            responseStructure.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            responseStructure.setMessage("An unexpected error occurred.");
            responseStructure.setData(new ArrayList<>());
            return new ResponseEntity<>(responseStructure, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    
    // for put 
    public String updateProduct(Product product) {
        Optional<Product> existingProduct = productRepository.findById(product.getProductId());

        if (existingProduct.isPresent()) {
            Product existing = existingProduct.get();
            existing.setProductName(product.getProductName());
            existing.setUnitPrice(product.getUnitPrice());
            existing.setColor(product.getColor());
            existing.setBrand(product.getBrand());
            existing.setSize(product.getSize());
            existing.setRating(product.getRating());

            productRepository.save(existing);

            return "Record Updated Successfully";
        } else {
            return "Product not found.";
        }
    }
    
	
}