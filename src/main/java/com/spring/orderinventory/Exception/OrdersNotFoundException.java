package com.spring.orderinventory.Exception;

public class OrdersNotFoundException extends RuntimeException{
	public OrdersNotFoundException(String message) {
		super(message);
	}
	
}
