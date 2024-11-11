package com.spring.orderinventory.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.orderinventory.entity.Customer;
import com.spring.orderinventory.repository.OrderItemsRepository;

@Repository
public class OrderItemDao {

	@Autowired
    private OrderItemsRepository orderItemRepository;

    public List<Customer> getCustomersByOrderQuantityRange(int minQuantity, int maxQuantity) {
        return orderItemRepository.findCustomersByOrderQuantityRange(minQuantity, maxQuantity);
    }
	
}
