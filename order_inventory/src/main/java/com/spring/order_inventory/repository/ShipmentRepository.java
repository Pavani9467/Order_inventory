package com.spring.order_inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.order_inventory.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment,Integer>{
	@Query("SELECT u FROM Shipment u")
	List<Shipment> getAllShipment();
	
	@Query("SELECT u FROM Shipment u WHERE u.shipmentId = ?1")
	List<Shipment> getByShipmentId(int id);
	
	@Query("SELECT s FROM Shipment s WHERE s.customerId.customerId = ?1")
	List<Shipment> getShipmentHistoryByCustomerId(int customerId);
	
	@Query("SELECT s FROM Shipment s WHERE s.shipmentStatus IN ('CREATED', 'IN-TRANSIT')")
	List<Shipment> getPendingShipmentsCustomerDetails();
	
	@Query("SELECT s FROM Shipment s WHERE s.shipmentStatus IN ('DELIVERED')")
	List<Shipment> getCompletedShipmentsCustomerDetails();
	

	
}
