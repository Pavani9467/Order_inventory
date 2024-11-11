package com.spring.order_inventory.Exception;

public class OrdersNotFoundException extends RuntimeException{
	public OrdersNotFoundException(String message) {
		super(message);
	}
	
}
