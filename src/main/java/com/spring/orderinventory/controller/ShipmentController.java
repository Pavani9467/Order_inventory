package com.spring.orderinventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.orderinventory.dto.ResponseStructure;
import com.spring.orderinventory.entity.Customer;
import com.spring.orderinventory.entity.Shipment;
import com.spring.orderinventory.repository.ShipmentRepository;
import com.spring.orderinventory.sevice.ShipmentServices;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/customers")
@Tag(name = "Shipment API", description = "Endpoints for managing shipments and customer orders")
public class ShipmentController {

	@Autowired
	ShipmentRepository shipmentRepository;
	
	@Autowired
	ShipmentServices shipmentServices;
	
	@GetMapping("/{custId}/shipment")
	public ResponseEntity<ResponseStructure<Shipment>> getShipments(@PathVariable int custId){
		return shipmentServices.getShipementDetailsByCustomerId(custId);
	}
	
	
	 @GetMapping("/shipments/pending")
	    public ResponseEntity<ResponseStructure<List<Customer>>> getPendingShipmentCustomers() {
	        return shipmentServices.getPendingShipmentCustomers();
	    }
    
	
//	@GetMapping("/orders/completed")
//    public ResponseEntity<ResponseStructure<List<Customer>>> getCompletedShipmentCustomers() {
//        return shipmentServices.getCompletedShipmentCustomers();
//    }
	
	
	
}
