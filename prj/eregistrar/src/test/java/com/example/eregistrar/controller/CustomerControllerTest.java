package com.example.eregistrar.controller;

import com.example.eregistrar.model.Customer;
import com.example.eregistrar.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    void shouldReturnCustomerListPage() throws Exception {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Alice");
        customer.setLastName("Smith");
        customer.setEmail("alice@example.com");
        customer.setPhone("12345");
        customer.setLicenseNumber("ABC123");
        customer.setAddress("Fairfield");

        when(customerService.getAllCustomers()).thenReturn(List.of(customer));

        mockMvc.perform(get("/customers/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("customers/list"));
    }
}
