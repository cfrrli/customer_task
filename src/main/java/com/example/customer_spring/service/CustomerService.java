package com.example.customer_spring.service;

import com.example.customer_spring.dto.CustomerDto;
import com.example.customer_spring.dto.CustomerDtoIU;
import com.example.customer_spring.mappper.CustomerMapping;
import com.example.customer_spring.models.Customer;
import com.example.customer_spring.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapping customerMapping;

    public CustomerDto finfByFinkod(String finkod) {
        return customerMapping.toCustomerDto(customerRepository.findByFinkod(finkod).orElseThrow());
    }

    public List<CustomerDto> getAll() {
        List<CustomerDto> listDtos = new ArrayList<>();
        for (Optional<Customer> c: customerRepository.getAll()) {
            listDtos.add(customerMapping.toCustomerDto(c.get()));
        }
        return listDtos;
    }

    public CustomerDto addCustomer (CustomerDtoIU customerDtoIU) {
        customerRepository.save(customerMapping.toCustomer(customerDtoIU));
        return customerMapping.toCustomerDto(customerDtoIU);
    }

    public void changeCustomer (CustomerDtoIU customerDtoIU) {
        if (!customerRepository.existsByFinkod(customerDtoIU.getFinkod())) {
            customerRepository.save(customerMapping.toCustomer(customerDtoIU));
        }
    }

    public void uptadeFields (CustomerDtoIU customerDtoIU) {
        if (customerRepository.findByFinkod(customerDtoIU.getFinkod()).equals(true)) {
            Optional<Customer> newCustomer = customerRepository.findByFinkod(customerDtoIU.getFinkod());
            if (!customerDtoIU.getFinkod().isEmpty()) newCustomer.get().setFinkod(customerDtoIU.getFinkod());
            if (!customerDtoIU.getName().isEmpty()) newCustomer.get().setName(customerDtoIU.getName());
            if (!customerDtoIU.getSurname().isEmpty()) newCustomer.get().setSurname(customerDtoIU.getSurname());
        }
    }

    public void deleteCustomer (Integer id) {
        customerRepository.deteteCustomerById(id);
    }



}
