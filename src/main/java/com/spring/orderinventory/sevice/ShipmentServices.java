package com.spring.orderinventory.sevice;


import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.orderinventory.Exception.CustomersWithCompletedShipmentsException;
import com.spring.orderinventory.Exception.CustomersWithPendingShipmentsException;
import com.spring.orderinventory.Exception.IdDoesNotPresentException;
import com.spring.orderinventory.dao.ShipmentDao;
import com.spring.orderinventory.dto.ResponseStructure;
import com.spring.orderinventory.entity.Customer;
import com.spring.orderinventory.entity.Shipment;
import com.spring.orderinventory.repository.ShipmentRepository;

@Service
public class ShipmentServices {
	
	@Autowired
	private ShipmentDao shipmentDao;
	
	@Autowired
	ShipmentRepository shipmentRepository;
	
	
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
//            pendingShipments = null;
            
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
	

	
