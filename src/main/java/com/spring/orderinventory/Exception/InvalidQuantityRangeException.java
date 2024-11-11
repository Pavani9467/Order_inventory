package com.spring.orderinventory.Exception;

public class InvalidQuantityRangeException extends RuntimeException{
	public InvalidQuantityRangeException(String message) {
		super(message);
	}
}
