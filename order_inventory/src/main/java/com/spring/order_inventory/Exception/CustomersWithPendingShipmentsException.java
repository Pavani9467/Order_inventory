package com.spring.order_inventory.Exception;

public class CustomersWithPendingShipmentsException extends RuntimeException{

	public CustomersWithPendingShipmentsException(String message) {
		super(message);
	}
	
}
