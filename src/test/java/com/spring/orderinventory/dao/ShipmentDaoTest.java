package com.spring.orderinventory.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.spring.orderinventory.entity.Shipment;
import com.spring.orderinventory.repository.ShipmentRepository;

class ShipmentDaoTest {

	@Mock
    private ShipmentRepository shipmentRepository;

    @InjectMocks
    private ShipmentDao shipmentDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);  
    }

    @Test
    public void testFetchShipmentHistory_WithValidCustomerId() {
        int customerId = 1;
        
        Shipment shipment = new Shipment(); 
        List<Shipment> mockShipments = Arrays.asList(shipment);
        when(shipmentRepository.getShipmentHistoryByCustomerId(customerId)).thenReturn(mockShipments);

        
        List<Shipment> result = shipmentDao.fetchShipmentHistory(customerId);

        
        assertNotNull(result);
        assertFalse(result.isEmpty());
        verify(shipmentRepository, times(1)).getShipmentHistoryByCustomerId(customerId);
    }

    @Test
    public void testFetchShipmentHistory_WithNoShipments() {
        int customerId = 1;
        when(shipmentRepository.getShipmentHistoryByCustomerId(customerId)).thenReturn(Arrays.asList());

        List<Shipment> result = shipmentDao.fetchShipmentHistory(customerId);

        assertNull(result);  
        verify(shipmentRepository, times(1)).getShipmentHistoryByCustomerId(customerId);
    }

    @Test
    public void testFetchPendingCustomerDetails_WithPendingShipments() {
        
        Shipment shipment = new Shipment();  
        List<Shipment> mockPendingShipments = Arrays.asList(shipment);
        when(shipmentRepository.getPendingShipmentsCustomerDetails()).thenReturn(mockPendingShipments);

        
        List<Shipment> result = shipmentDao.fetchPendingCustomerDetails();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        verify(shipmentRepository, times(1)).getPendingShipmentsCustomerDetails();
    }

    @Test
    public void testFetchPendingCustomerDetails_WithNoPendingShipments() {
        when(shipmentRepository.getPendingShipmentsCustomerDetails()).thenReturn(Arrays.asList());

        List<Shipment> result = shipmentDao.fetchPendingCustomerDetails();

        assertNull(result); 
        verify(shipmentRepository, times(1)).getPendingShipmentsCustomerDetails();
    }

    @Test
    public void testFetchCompletedCustomerDetails_WithCompletedShipments() {
        
        Shipment shipment = new Shipment();  
        List<Shipment> mockCompletedShipments = Arrays.asList(shipment);
        when(shipmentRepository.getCompletedShipmentsCustomerDetails()).thenReturn(mockCompletedShipments);

        
        List<Shipment> result = shipmentDao.fetchCompletedCustomerDetails();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        verify(shipmentRepository, times(1)).getCompletedShipmentsCustomerDetails();
    }

    @Test
    public void testFetchCompletedCustomerDetails_WithNoCompletedShipments() {
        when(shipmentRepository.getCompletedShipmentsCustomerDetails()).thenReturn(Arrays.asList());

        List<Shipment> result = shipmentDao.fetchCompletedCustomerDetails();

        assertNull(result);  
        verify(shipmentRepository, times(1)).getCompletedShipmentsCustomerDetails();
    }
	
}
