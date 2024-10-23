package com.cab_billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cab_billing.entity.Billing;
import java.util.List;


@Repository
public interface BillingRepository extends JpaRepository<Billing, Integer> {
	
	List<Billing> findByBookingId(int bookingId);
}
