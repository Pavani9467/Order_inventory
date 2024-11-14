package com.spring.orderinventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.orderinventory.dto.ResponseStructure;
import com.spring.orderinventory.entity.Customer;
import com.spring.orderinventory.entity.Shipment;
import com.spring.orderinventory.repository.ShipmentRepository;
import com.spring.orderinventory.sevice.ShipmentServices;

@RestController
public class ShipmentController {

	@Autowired
	ShipmentRepository shipmentRepository;
	
	@Autowired
	ShipmentServices shipmentServices;
	
	@GetMapping("/api/v1/customers/{custId}/shipment")
	public ResponseEntity<ResponseStructure<Shipment>> getShipments(@PathVariable int custId){
		return shipmentServices.getShipementDetailsByCustomerId(custId);
	}
	
	
	 @GetMapping("/api/v1/customers/shipments/pending")
	    public ResponseEntity<ResponseStructure<List<Customer>>> getPendingShipmentCustomers() {
	        return shipmentServices.getPendingShipmentCustomers();
	    }
    
	
	@GetMapping("/api/v1/customers/orders/completed")
    public ResponseEntity<ResponseStructure<List<Customer>>> getCompletedShipmentCustomers() {
        return shipmentServices.getCompletedShipmentCustomers();
    }
	
	
	
}
