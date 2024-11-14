package com.spring.orderinventory.Exception;

public class InvalidProductDataException extends RuntimeException{
	public InvalidProductDataException(String message) {
		super(message);
	}
}
