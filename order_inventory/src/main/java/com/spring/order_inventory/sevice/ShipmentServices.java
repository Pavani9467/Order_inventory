package com.spring.order_inventory.sevice;


import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.order_inventory.Exception.CustomersWithCompletedShipmentsException;
import com.spring.order_inventory.Exception.CustomersWithPendingShipmentsException;
import com.spring.order_inventory.Exception.IdDoesNotPresentException;
import com.spring.order_inventory.dao.ShipmentDao;
import com.spring.order_inventory.dto.ResponseStructure;
import com.spring.order_inventory.entity.Customer;
import com.spring.order_inventory.entity.Shipment;

@Service
public class ShipmentServices {
	
	@Autowired
	private ShipmentDao shipmentDao;
	
	
	public ResponseEntity<ResponseStructure<Shipment>> getShipementDetailsByCustomerId(int id){
		List<Shipment> shipmentDetails = shipmentDao.fetchShipmentHistory(id);
		if(shipmentDetails != null && !shipmentDetails.isEmpty()) {
			ResponseStructure<Shipment> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(shipmentDetails);
			return new ResponseEntity<>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdDoesNotPresentException("Shipment history for the specified customer ID = "+id+" not found.");
		}
	}
	
	
	public ResponseEntity<ResponseStructure<List<Customer>>> getPendingShipmentCustomers() {
        ResponseStructure<List<Customer>> responseStructure = new ResponseStructure<>();
        
        try {
            List<Shipment> pendingShipments = shipmentDao.fetchPendingCustomerDetails();
            pendingShipments = null;
            
            List<Customer> customersWithPendingShipments = pendingShipments.stream()
                .map(Shipment::getCustomerId)
                .distinct()
                .toList();

            responseStructure.setStatusCode(HttpStatus.OK.value());
            responseStructure.setMessage("Pending shipment customers retrieved successfully");
            responseStructure.setData(Collections.singletonList(customersWithPendingShipments));
            
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);

        } catch (Exception e) {
            throw new CustomersWithPendingShipmentsException("An internal server error occurred while fetching customers with pending shipments");
        }
    }
	
	
	public ResponseEntity<ResponseStructure<List<Customer>>> getCompletedShipmentCustomers() {
        ResponseStructure<List<Customer>> responseStructure = new ResponseStructure<>();
        
        try {
            List<Shipment> completedShipments = shipmentDao.fetchCompletedCustomerDetails();
           
            List<Customer> customersWithPendingShipments = completedShipments.stream()
                .map(Shipment::getCustomerId)
                .distinct()
                .toList();

            responseStructure.setStatusCode(HttpStatus.OK.value());
            responseStructure.setMessage("completed shipments retrieved successfully");
            responseStructure.setData(Collections.singletonList(customersWithPendingShipments));
            
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);

        } catch (Exception e) {
            throw new CustomersWithCompletedShipmentsException("An internal server error occurred while fetching customers with completed orders.");
        }
    }
	
	
	
	
}
	

	
