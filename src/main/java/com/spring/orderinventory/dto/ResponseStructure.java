package com.spring.orderinventory.dto;

import java.util.List;



import lombok.Data;

@Data
public class ResponseStructure<T>{

	private int statusCode;
	private String message;
	private List<T> data;
	
	
}
