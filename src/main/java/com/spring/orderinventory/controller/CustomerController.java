package com.spring.orderinventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.orderinventory.Exception.CustomerNotFoundException;
import com.spring.orderinventory.dto.AddressUpdateRequest;
import com.spring.orderinventory.entity.Customer;
import com.spring.orderinventory.sevice.CustomerService;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    
    @PutMapping("/customers/{customerId}/address")
    public ResponseEntity<Customer> updateCustomerAddress(@PathVariable int customerId, @RequestBody AddressUpdateRequest addressUpdateRequest) {
        try {
            // Extract the address from the DTO
            String newAddress = addressUpdateRequest.getNewAddress();
            
            Customer updatedCustomer = customerService.updateCustomerAddress(customerId, newAddress);
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
}
