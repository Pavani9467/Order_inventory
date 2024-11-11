package com.spring.order_inventory.Exception;


public class CustomersWithCompletedShipmentsException extends RuntimeException{
	public CustomersWithCompletedShipmentsException(String message) {
		super(message);
	}
}
