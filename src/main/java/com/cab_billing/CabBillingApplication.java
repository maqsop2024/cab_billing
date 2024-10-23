package com.cab_billing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.cab_billing")
@EnableDiscoveryClient
@EntityScan(basePackages = "com.cab_billing.entity")
@EnableJpaRepositories(basePackages = "com.cab_billing.repository")
public class CabBillingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabBillingApplication.class, args);
		System.err.println("Cab bliing micro service up on port number 9292");
	}
	// this method is responsible to create the object.
		// object creation taken care by us but maintain by container.

		@Bean
		@LoadBalanced // we can call account micro service by name rather than physical ip address
						// with port number.
		public RestTemplate restTemplate() {
			return new RestTemplate();
		}

}
