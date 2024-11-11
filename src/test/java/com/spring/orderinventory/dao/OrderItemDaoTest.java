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


import com.spring.orderinventory.entity.Customer;
import com.spring.orderinventory.repository.OrderItemsRepository;

class OrderItemDaoTest {

	@Mock
    private OrderItemsRepository orderItemRepository;

    @InjectMocks
    private OrderItemDao orderItemDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);  // Initialize mocks
    }

    @Test
    public void testGetCustomersByOrderQuantityRange_WithValidRange() {
        int minQuantity = 10;
        int maxQuantity = 50;

        
        Customer customer = new Customer();  
        customer.setCustomerId(1);
        customer.setFullName("John Doe");

        
        when(orderItemRepository.findCustomersByOrderQuantityRange(minQuantity, maxQuantity))
                .thenReturn(Arrays.asList(customer));

        
        List<Customer> result = orderItemDao.getCustomersByOrderQuantityRange(minQuantity, maxQuantity);

        
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());  
        assertEquals("John Doe", result.get(0).getFullName());  
        verify(orderItemRepository, times(1))
                .findCustomersByOrderQuantityRange(minQuantity, maxQuantity);  
    }

    @Test
    public void testGetCustomersByOrderQuantityRange_WithNoCustomersFound() {
        int minQuantity = 10;
        int maxQuantity = 50;

        
        when(orderItemRepository.findCustomersByOrderQuantityRange(minQuantity, maxQuantity))
                .thenReturn(Arrays.asList());

        
        List<Customer> result = orderItemDao.getCustomersByOrderQuantityRange(minQuantity, maxQuantity);

        
        assertNotNull(result);
        assertTrue(result.isEmpty());  
        verify(orderItemRepository, times(1))
                .findCustomersByOrderQuantityRange(minQuantity, maxQuantity);  
    }

    @Test
    public void testGetCustomersByOrderQuantityRange_WithNullRepositoryResponse() {
        int minQuantity = 10;
        int maxQuantity = 50;

     
        when(orderItemRepository.findCustomersByOrderQuantityRange(minQuantity, maxQuantity))
                .thenReturn(null);

        
        List<Customer> result = orderItemDao.getCustomersByOrderQuantityRange(minQuantity, maxQuantity);

        
        assertNull(result);  
        verify(orderItemRepository, times(1))
                .findCustomersByOrderQuantityRange(minQuantity, maxQuantity);  
    }

}
