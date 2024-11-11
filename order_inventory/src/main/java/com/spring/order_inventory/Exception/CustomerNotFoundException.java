package com.spring.order_inventory.Exception;

public class CustomerNotFoundException extends RuntimeException{
	public CustomerNotFoundException(String message) {
        super(message);
    }
}
