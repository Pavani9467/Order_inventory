package com.spring.order_inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.order_inventory.dto.ResponseStructure;
import com.spring.order_inventory.entity.Customer;
import com.spring.order_inventory.entity.Shipment;
import com.spring.order_inventory.repository.ShipmentRepository;
import com.spring.order_inventory.sevice.OrderItemService;
import com.spring.order_inventory.sevice.ShipmentServices;

@RestController
public class ShipmentController{

	@Autowired
	ShipmentRepository shipmentRepository;
	
	@GetMapping("/find")
	public List<Shipment> findAllRecordsOfCustomer(){
		List<Shipment> findAllRecordsOfCustomer= shipmentRepository.findAll();
		return findAllRecordsOfCustomer;
	}
	
	@GetMapping("/shipment1")
	public List<Shipment> ship(){
		List<Shipment> listu = shipmentRepository.getAllShipment();
		return listu;
	}
	
	@GetMapping("/shipment2/{id}")
	public List<Shipment> ship2(@PathVariable int id){
		List<Shipment> listuu = shipmentRepository.getByShipmentId(id);
		return listuu;
	}
	
	@GetMapping("/api/v1/customers/{custId}/shipment1")
	public List<Shipment> fetchShipmentHistory(@PathVariable int custId) {
	    List<Shipment> shipmentsOfCustomer = shipmentRepository.getShipmentHistoryByCustomerId(custId);
	    return shipmentsOfCustomer;
	}
	
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
	
//	 @Autowired
//	    private OrderItemService orderItemService;
//
//	    @GetMapping("/api/v1/customers/orders/quantity/{min}/{max}")
//	    public ResponseEntity<ResponseStructure<List<Customer>>> getCustomersByOrderQuantityRange(
//	            @PathVariable int min,
//	            @PathVariable int max) {
//	        
//	        return orderItemService.getCustomersByOrderQuantityRange(min, max);
//	       
//	    }
//	
	  
	
}
