package com.spring.orderinventory.Exception;


public class CustomersWithCompletedShipmentsException extends RuntimeException{
	public CustomersWithCompletedShipmentsException(String message) {
		super(message);
	}
}
