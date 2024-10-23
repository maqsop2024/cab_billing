package com.cab_billing.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Billing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int billingId;
	private int bookingId;
	private float mileage;
	private float charge;

}
