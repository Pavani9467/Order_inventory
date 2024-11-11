package com.spring.order_inventory.Exception;

public class InvalidQuantityRangeException extends RuntimeException{
	public InvalidQuantityRangeException(String message) {
		super(message);
	}
}
