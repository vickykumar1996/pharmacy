package com.apollo.pharmacy;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Pharmacy Management System API",
				version = "1.0",
				description = "API documentation for Pharmacy Management System",
				termsOfService = "http://pharmacyapp.com/terms",
				contact = @Contact(
						name = "Vicky Kumar",
						email = "vk7343270@gmail.com"
				)
		)
)
public class PharmacyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmacyApplication.class, args);
	}

}
