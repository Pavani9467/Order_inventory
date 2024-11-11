package com.spring.orderinventory.Exception;

public class CustomersWithPendingShipmentsException extends RuntimeException{

	public CustomersWithPendingShipmentsException(String message) {
		super(message);
	}
	
}
