package com.spring.order_inventory.dto;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.spring.order_inventory.entity.Order;

import lombok.Data;

@Data
public class ResponseStructure<T>{

	private int statusCode;
	private String message;
	private List<T> data;
	
	
}
