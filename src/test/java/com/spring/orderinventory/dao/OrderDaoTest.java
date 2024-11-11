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

import com.spring.orderinventory.entity.Order;
import com.spring.orderinventory.repository.OrderRepository;

class OrderDaoTest {

	@Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderDao orderDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);  
    }

    @Test
    public void testFindingOrders_WithOrders() {
        String email = "customer@example.com";
        
        
        Order order = new Order();  
        order.setOrderId(1);
        order.setOrderStatus("Pending");
        
        
        when(orderRepository.findOrdersByCustomerEmail(email))
                .thenReturn(Arrays.asList(order));

        
        List<Order> result = orderDao.findingOrders(email);

        
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());  
        assertEquals("Pending", result.get(0).getOrderStatus());  
        verify(orderRepository, times(1)).findOrdersByCustomerEmail(email);  
    }

    @Test
    public void testFindingOrders_WithNoOrders() {
        String email = "customer@example.com";

        
        when(orderRepository.findOrdersByCustomerEmail(email))
                .thenReturn(Arrays.asList());

        
        List<Order> result = orderDao.findingOrders(email);

        
        assertNull(result);  
        verify(orderRepository, times(1)).findOrdersByCustomerEmail(email);  
    }

}
