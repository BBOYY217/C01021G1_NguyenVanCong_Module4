package com.codegym.repository;

import com.codegym.model.Customer;

import java.util.List;

public interface CustomerRepositoryImpl {
    List<Customer> findAll();

    Customer findOne(Long id);

    Customer save(Customer customer);

}
