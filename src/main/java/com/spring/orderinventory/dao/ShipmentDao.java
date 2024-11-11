package com.spring.orderinventory.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.orderinventory.entity.Shipment;
import com.spring.orderinventory.repository.ShipmentRepository;

@Repository
public class ShipmentDao {

	@Autowired
	ShipmentRepository shipmentRepository;
	
	public List<Shipment> fetchShipmentHistory(int custId) {
	    List<Shipment> shipmentsOfCustomer = shipmentRepository.getShipmentHistoryByCustomerId(custId);
	    if(shipmentsOfCustomer.isEmpty()) {
	    	return null;
	    }
	    return shipmentsOfCustomer;
	}
	
	public List<Shipment> fetchPendingCustomerDetails(){
		List<Shipment> shipmentsPendingOfCustomers = shipmentRepository.getPendingShipmentsCustomerDetails();
		if(shipmentsPendingOfCustomers.isEmpty()) {
			return null;
		}
		return shipmentsPendingOfCustomers;
	}
	
	public List<Shipment> fetchCompletedCustomerDetails(){
		List<Shipment> shipmentsCompletedOfCustomers = shipmentRepository.getCompletedShipmentsCustomerDetails();
		if(shipmentsCompletedOfCustomers.isEmpty()) {
			return null;
		}
		return shipmentsCompletedOfCustomers;
	}
	
}
