package com.example.customer_spring.mappper;

import com.example.customer_spring.dto.CustomerDto;
import com.example.customer_spring.dto.CustomerDtoIU;
import com.example.customer_spring.models.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (componentModel = "spring")
public interface CustomerMapping {

    CustomerDto toCustomerDto(Customer customer);

    CustomerDto toCustomerDto (CustomerDtoIU customerDtoIU);

    Customer toCustomer(CustomerDto customerDto);

    Customer toCustomer(CustomerDtoIU customerDtoIU);



}
