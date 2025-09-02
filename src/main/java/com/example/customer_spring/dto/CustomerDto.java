package com.example.customer_spring.dto;

import lombok.*;
import org.mapstruct.Mapping;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDto {

    private String name;
    private String surname;
    private Integer age;

    public CustomerDto (CustomerDtoBuilder cs) {
        this.name = cs.name;
        this.age = cs.age;
        this.surname = cs.surname;
    }

    public static CustomerDtoBuilder builder () {
        return new CustomerDtoBuilder();
    }


    public static class CustomerDtoBuilder {
        private String name;
        private String surname;
        private Integer age;

        public CustomerDtoBuilder name (String name) {
            this.name = name;
            return this;
        }
        public CustomerDtoBuilder surname (String surname) {
            this.surname = surname;
            return this;
        }
        public CustomerDtoBuilder age (Integer age) {
            this.age = age;
            return this;
        }

        public CustomerDto build () {
            return new CustomerDto (this);
        }

    }


}
