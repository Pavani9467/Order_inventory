package com.spring.order_inventory.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.order_inventory.entity.Shipment;
import com.spring.order_inventory.repository.ShipmentRepository;

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
