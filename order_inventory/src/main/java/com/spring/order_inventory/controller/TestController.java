package com.spring.order_inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.order_inventory.entity.Customer;
import com.spring.order_inventory.entity.Inventory;
import com.spring.order_inventory.entity.Order;
import com.spring.order_inventory.entity.OrderItem;
import com.spring.order_inventory.entity.Product;
import com.spring.order_inventory.entity.Shipment;
import com.spring.order_inventory.entity.Store;
import com.spring.order_inventory.repository.CustomerRepository;
import com.spring.order_inventory.repository.InventoryRepository;
import com.spring.order_inventory.repository.OrderItemsRepository;
import com.spring.order_inventory.repository.OrderRepository;
import com.spring.order_inventory.repository.ProductRepository;
import com.spring.order_inventory.repository.ShipmentRepository;
import com.spring.order_inventory.repository.StoreRepository;

@RestController
public class TestController {

	@GetMapping("/info")
	public String message() {
		return "jesus";
	}

	@Autowired
	CustomerRepository customerRepository;

	@GetMapping("/demo")
	public List<Customer> getCustomers() {
		List<Customer> cus = customerRepository.findAll();
		return cus;
	}
	
	@Autowired
	StoreRepository storeRepository;
	
	@GetMapping("/demo1")
	public List<Store> getStoreDetails(){
		List<Store> store = storeRepository.findAll();
		return store;
	}
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/demo2")
	public List<Product> getProductDetails(){
		List<Product> product = productRepository.findAll();
		return product;
	}
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	@GetMapping("/demo3")
	public List<Inventory> getInventoryDetails(){
		List<Inventory> inventory = inventoryRepository.findAll();
		return inventory;
	}
	
	@Autowired
	OrderRepository orderRepository;
	
	@GetMapping("/demo4")
	public List<Order> getOrderInventoryDetails(){
		List<Order> order = orderRepository.findAll();
		return order;
	}
	
	@Autowired
	OrderItemsRepository orderItemsRepository;
	
	@GetMapping("/demo5")
	public List<OrderItem> getOrderItemDetails(){
		List<OrderItem> orderItem = orderItemsRepository.findAll();
		return orderItem;
	}
	
	@Autowired
	ShipmentRepository shipmentRepository;
	
	@GetMapping("/demo6")
	public List<Shipment> getShipmentDetails(){
		List<Shipment> shipment = shipmentRepository.findAll();
		return shipment;
	}
	
}
