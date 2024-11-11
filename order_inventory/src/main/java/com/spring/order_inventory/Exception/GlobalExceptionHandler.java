package com.spring.order_inventory.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.order_inventory.dto.ResponseStructure;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({IdDoesNotPresentException.class,CustomerNotFoundException.class,OrdersNotFoundException.class})
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
	
	
	
}
