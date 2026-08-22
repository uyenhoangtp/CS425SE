package com.example.eregistrar.repository;

import com.example.eregistrar.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void shouldSaveCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Anna");
        customer.setLastName("Lee");
        customer.setEmail("anna@example.com");
        customer.setPhone("123456");
        customer.setLicenseNumber("LIC-1001");
        customer.setAddress("Fairfield");

        Customer saved = customerRepository.save(customer);

        assertNotNull(saved.getId());
    }
}
