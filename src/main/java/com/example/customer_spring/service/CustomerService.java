package com.example.customer_spring.service;

import com.example.customer_spring.dto.CustomerDto;
import com.example.customer_spring.models.Customer;
import com.example.customer_spring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;


    public CustomerService (CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer finfByFinkod (String finkod) {
            return customerRepository.findByFinkod(finkod).orElseThrow();
    }

    public List<CustomerDto> getAll () {

        return null;
    }


}
