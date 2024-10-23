package com.cab_billing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.MediaType;


import com.cab_billing.entity.BillingRequest;
import com.cab_billing.service.BillingService;

@RestController
@RequestMapping("billing")
public class BillingController {
	
	@Autowired
	BillingService billingService;
	
//	@Autowired
//	Billing bill; 
	
	@PostMapping(value = "createBill", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createBill(@RequestBody BillingRequest billing) {
		
		
		return billingService.createBill(billing);
	}
	
	
	

	

}
