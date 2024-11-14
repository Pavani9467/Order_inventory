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
            // Find all shipments related to the customer and update their addresses
            List<Shipment> shipments = shipmentRepository.findByCustomerId(customer);

            // Update the delivery address in all shipments
            for (Shipment shipment : shipments) {
                shipment.setDeliveryAddress(newAddress);
                shipmentRepository.save(shipment);
            }

            // Set the new address in the customer's record (if needed)
            // customer.setAddress(newAddress); // If Customer entity has an address field

            // Return the updated customer
            return customerRepository.save(customer);
        }

        // If customer not found, return null
        return null;
    }
    
   
}
