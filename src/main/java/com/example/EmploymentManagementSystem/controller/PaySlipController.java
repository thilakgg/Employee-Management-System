package com.example.EmploymentManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmploymentManagementSystem.model.PaySlip;
import com.example.EmploymentManagementSystem.service.PaySlipService;
import com.itextpdf.text.DocumentException;

@RestController
public class PaySlipController {
	
	@Autowired
	PaySlipService service;
	
	@GetMapping("/processPayment") 
	public void processPayment() {
		service.processPayment();
	}
	
	@GetMapping("/getPaySlip")
	public List<PaySlip> getPaySlips(){
		return service.getPaySlips();
	}
	
	@GetMapping("/{id}/getPaySlip")
	public PaySlip getPaySlip(@PathVariable Long id) {
		return service.getPaySlip(id);
	}
	
	@GetMapping("/{id}/generatePaySlip")
	public String generatePaySlip(@PathVariable Long id) throws DocumentException, Exception {
		return service.generatePaySlip(id);
	}

}
