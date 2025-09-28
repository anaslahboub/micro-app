package com.anas.accountservice.clients;


import com.anas.accountservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
    Customer getCustomer(@PathVariable Long id);

    @GetMapping("/customers")
    List<Customer> getCustomers();

    default Customer getDefaultCustomer(Long id,  Exception exception) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("not available");
        customer.setLastName("not available");
        customer.setEmail("not available@email.com");
        return customer;
    }
}
