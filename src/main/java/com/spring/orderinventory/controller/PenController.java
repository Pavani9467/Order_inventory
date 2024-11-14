package com.spring.orderinventory.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.orderinventory.entity.Pen;
import com.spring.orderinventory.repository.PenRepository;



@RestController
public class PenController {
	@Autowired 
	PenRepository penRepository;

	@PostMapping("/demopen/{id}")
	public Pen penmethod(@RequestBody Pen pen) {
		return penRepository.save(pen);
	}
	
}
