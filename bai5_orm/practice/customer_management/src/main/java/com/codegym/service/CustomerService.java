package com.codegym.service;

import com.codegym.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CustomerService {
    List<Customer> findAll();
    Customer findOne(Long id);
    Customer save(Customer customer);
    List<Customer> save(List<Customer> customers);
    boolean exists(Long id);
    List<Customer> findAll(List<Long> ids);
    long count();
    void delete(Long id);
    void delete(Customer customer);
    void delete(List<Customer> customers);
    void deleteAll();

}
