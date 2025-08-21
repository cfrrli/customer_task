package com.example.customer_spring.controller;

import com.example.customer_spring.dto.CustomerDto;
import com.example.customer_spring.models.Customer;
import com.example.customer_spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/findByFinkod")
    public Customer finfByFinkod(@RequestParam String finkod) {
        return customerService.finfByFinkod(finkod);
    }
    @GetMapping
    public List<CustomerDto> getAll () {
        return customerService.getAll();
    }

}
