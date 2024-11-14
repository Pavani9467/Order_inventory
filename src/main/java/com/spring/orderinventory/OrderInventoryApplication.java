package com.spring.orderinventory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;



@SpringBootApplication
public class OrderInventoryApplication {
	
	@Value("${server.port}")
    private String serverPort;

	public static void main(String[] args) {
		SpringApplication.run(OrderInventoryApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
    public void logStartup() {
        System.out.println("Application started on port: " + serverPort);
    }

}
