package com.spring.orderinventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.orderinventory.entity.Product;
import com.spring.orderinventory.sevice.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
    private ProductService productService;

    @PostMapping("/bulkAdd")
    public ResponseEntity<?> bulkAddProducts(@RequestBody List<Product> products) {
        return productService.addProductsInBulk(products);
    }
    
    
    //for put 
    @PutMapping("/api/v1")
    public ResponseEntity<String> updateProduct(@RequestBody Product product) {
        try {
            // Check if the product or productId is invalid (assuming productId should be a positive number)
            if (product == null || product.getProductId() <= 0) {
                return new ResponseEntity<>("Invalid request. Please provide valid product data for updating.", HttpStatus.BAD_REQUEST);
            }

            // Call service layer to perform the update
            String result = productService.updateProduct(product);

            // Check the result from the service layer
            if ("Record Updated Successfully".equals(result)) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Product not found.", HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            // Handle any unexpected exceptions
            return new ResponseEntity<>("An error occurred while updating the product.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    /*http://localhost:8081/products/api/v1
    {
    	  "productId": 1,
    	  "productName": "pavani",
    	  "unitPrice": 100.0,
    	  "color": "Red",
    	  "brand": "Updated Brand",
    	  "size": "L",
    	  "rating": "5"
    	}
*/

    
}