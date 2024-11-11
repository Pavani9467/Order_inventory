package com.spring.orderinventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class Customer {
	@Id
	@Column(name = "customer_id")
	private int customerId;
	@Column(name = "email_address")
	private String emailAddress;
	@Column(name = "full_name")
	private String fullName;
	

}
