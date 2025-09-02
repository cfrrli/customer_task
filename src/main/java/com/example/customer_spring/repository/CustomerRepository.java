package com.example.customer_spring.repository;

import com.example.customer_spring.models.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    boolean existsByFinkod(String finkod);

    @Query("select c from Customer c where c.finkod = :finkod")
    Optional<Customer> findByFinkod(String finkod);

    @Query(value = "select * from customer", nativeQuery = true)
    List < Optional<Customer>>  getAll();

    @Modifying
    @Transactional
    @Query(value = "delete from Customer c where c.id = :id")
    void deteteCustomerById(@Param("id") Integer id);


}
