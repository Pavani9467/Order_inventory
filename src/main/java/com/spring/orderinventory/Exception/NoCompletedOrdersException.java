package com.spring.orderinventory.Exception;

public class NoCompletedOrdersException extends RuntimeException{
	public NoCompletedOrdersException(String message) {
        super(message);
    }
}
