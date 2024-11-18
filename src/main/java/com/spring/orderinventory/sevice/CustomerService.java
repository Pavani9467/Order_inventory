package com.spring.orderinventory.sevice;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.orderinventory.entity.Customer;
import com.spring.orderinventory.entity.Shipment;
import com.spring.orderinventory.repository.CustomerRepository;
import com.spring.orderinventory.repository.ShipmentRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ShipmentRepository shipmentRepository;

    // Update the address of the customer
    public Customer updateCustomerAddress(int customerId, String newAddress) {
        // Find the customer by customerId
        Customer customer = customerRepository.findById(customerId).orElse(null);

        if (customer != null) {
            List<Shipment> shipments = shipmentRepository.findByCustomerId(customer);

            for (Shipment shipment : shipments) {
                shipment.setDeliveryAddress(newAddress);
                shipmentRepository.save(shipment);
            }

            return customerRepository.save(customer);
        }

        return null;
    }
    
    
    
   
}
