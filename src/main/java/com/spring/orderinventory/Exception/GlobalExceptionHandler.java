package com.spring.orderinventory.Exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.orderinventory.dto.ResponseStructure;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({IdDoesNotPresentException.class,CustomerNotFoundException.class,OrdersNotFoundException.class,NoCompletedOrdersException.class})
    public ResponseEntity<ResponseStructure<String>> handleIdDoesNotPresentException(IdDoesNotPresentException ex) {
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseStructure.setMessage(ex.getMessage());
        responseStructure.setData(null); // Set data to null if there’s no data to return
        
        return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
    }
	
	
	@ExceptionHandler({CustomersWithPendingShipmentsException.class, CustomersWithCompletedShipmentsException.class})
    public ResponseEntity<ResponseStructure<Void>> handleCustomerDataFetchException(CustomersWithPendingShipmentsException ex) {
        ResponseStructure<Void> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseStructure.setMessage(ex.getMessage());
        responseStructure.setData(null);
        
        return new ResponseEntity<>(responseStructure, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(InvalidQuantityRangeException.class)
	public ResponseEntity<ResponseStructure<String>> handleInvalidQuantityRangeException(InvalidQuantityRangeException ex) {
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
        responseStructure.setMessage(ex.getMessage());
        responseStructure.setData(null);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseStructure);
    }
	
	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseStructure<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        ResponseStructure<Object> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
        responseStructure.setMessage("Invalid request. " + ex.getMessage());
        responseStructure.setData(Collections.emptyList());
        return responseStructure;
    }

//	@ExceptionHandler(InvalidProductDataException.class)
//    public ResponseEntity<String> handleInvalidProductDataException(InvalidProductDataException ex) {
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//    }
	
	
	@ExceptionHandler(InvalidProductDataException.class)
    public ResponseEntity<ResponseStructure<String>> handleInvalidProductDataException(InvalidProductDataException ex) {
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
        responseStructure.setMessage(ex.getMessage());
        responseStructure.setData(new ArrayList<>());
        return new ResponseEntity<>(responseStructure, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseStructure<String>> handleGeneralException(Exception ex) {
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseStructure.setMessage("An unexpected error occurred.");
        responseStructure.setData(new ArrayList<>());
        return new ResponseEntity<>(responseStructure, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ResponseStructure<?>> handleProductNotFound(ProductNotFoundException ex) {
        ResponseStructure<?> response = new ResponseStructure<>();
        response.setStatusCode(400);
        response.setMessage(ex.getMessage());
        response.setData(List.of());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    
   
    
	
}
