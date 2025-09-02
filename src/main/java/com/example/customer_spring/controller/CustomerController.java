package com.example.customer_spring.controller;

import com.example.customer_spring.dto.CustomerDto;
import com.example.customer_spring.dto.CustomerDtoIU;
import com.example.customer_spring.models.Customer;
import com.example.customer_spring.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final  CustomerService customerService;


    @GetMapping("/findByFinkod")
    public CustomerDto finfByFinkod(@RequestParam String finkod) {

        return customerService.finfByFinkod(finkod);
    }


    @GetMapping
    public List<CustomerDto> getAll () {
        return customerService.getAll();
    }

    @PostMapping
    public CustomerDto addCustomer (@RequestBody CustomerDtoIU customerDtoIU) {
        return customerService.addCustomer(customerDtoIU);
    }

    @PutMapping
    public void changeCustomer (@RequestBody CustomerDtoIU customerDtoIU) {
        customerService.changeCustomer(customerDtoIU);
    }

    @PatchMapping
    public void uptadeFields (@RequestBody CustomerDtoIU customerDtoIU) {
        customerService.uptadeFields(customerDtoIU);
    }

    @DeleteMapping
    public void deleteCustomer (@RequestParam Integer id) {
        customerService.deleteCustomer(id);
    }

}
