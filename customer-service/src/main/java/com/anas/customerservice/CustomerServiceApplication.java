package com.anas.customerservice;

import com.anas.customerservice.entities.Customer;
import com.anas.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			// Création des clients de test
			Customer c1 = new Customer(null, "Anas", "Lahboub", "anas@gmail.com");

			Customer c2 = Customer.builder()
					.firstName("John")
					.lastName("Doe")
					.email("john.doe@example.com")
					.build();

			Customer c3 = Customer.builder()
					.firstName("Jane")
					.lastName("Smith")
					.email("jane.smith@example.com")
					.build();

			Customer c4 = Customer.builder()
					.firstName("Alice")
					.lastName("Johnson")
					.email("alice.johnson@example.com")
					.build();

			// Vérification si la base est déjà peuplée pour éviter les doublons
			if (customerRepository.count() == 0) {
				List<Customer> customers = Arrays.asList(c1, c2, c3, c4);
				customerRepository.saveAll(customers);

				System.out.println("✅ Données de test initialisées : " + customers.size() + " clients créés");
			} else {
				System.out.println("ℹ️  La base contient déjà des données (" + customerRepository.count() + " clients)");
			}
		};
	}
}