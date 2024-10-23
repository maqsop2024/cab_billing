package com.cab_billing.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cab_billing.entity.Billing;
import com.cab_billing.entity.BillingRequest;
import com.cab_billing.entity.Booking;
import com.cab_billing.repository.BillingRepository;




@Service
public class BillingService {
	@Autowired
	BillingRepository billingRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
//	@Autowired
//	Billing bill;
 
	
	public String createBill(BillingRequest billingRequest) {

		
//		Billing bill = new Billing();
//		Billing bill;
		Booking data = restTemplate.getForObject("http://cabbooking/booking/getBooking/" + billingRequest.getBookingId() , Booking.class);
		
		
		float chrg = 0;
		
		if(data == null) {
			return "This booking ID " + billingRequest.getBookingId() +" does not Exist";
		}
		
		
		if (data.getCabType().toString().equals("Rickshaw")) {		
			chrg = 5 * billingRequest.getMileage();
			System.out.println("charge = " + chrg);
			
		}
		else if (data.getCabType().toString().equals("Luxury")) {
			chrg = 100 * billingRequest.getMileage();
			System.out.println("charge = " + chrg);
		}
		else if (data.getCabType().toString().equals("Economy"))  {
			chrg = 50 * billingRequest.getMileage();
			System.out.println("charge = " + chrg);
		}
		
		 List<Billing> bresult =  billingRepository.findByBookingId(billingRequest.getBookingId());
		 System.out.println("bresult = >"+bresult.isEmpty());
		 Billing bill = new Billing();

		 // the following if condition only executes if the booking id does not exist in the billing table.
		 // only create a bill records for the new booking
		if (bresult.isEmpty()){
			bill.setBookingId(billingRequest.getBookingId());
			bill.setMileage(billingRequest.getMileage());
			bill.setCharge(chrg);
			Billing resultBilling;
			resultBilling=billingRepository.save(bill);
			billingRepository.save(bill);
			System.out.println(bill);
			return resultBilling + "Fare of " + data.getCabType().toString() + " Cab for distance " + billingRequest.getMileage()+ " is " + chrg;
		}
		else {
			return "Cannot create new charge for the existing booking Id "+ billingRequest.getBookingId();
		}
		

		
		

		
		
	}
	


}
