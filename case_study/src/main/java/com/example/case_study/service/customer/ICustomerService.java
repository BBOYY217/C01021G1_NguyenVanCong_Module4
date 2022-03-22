package com.example.case_study.service.customer;

import com.example.case_study.model.customer.Customer;
import com.example.case_study.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(String keyword, Pageable pageable);
    Customer findById(String id);
    void save(Customer customer);
    void remove(String id);
    List<CustomerType> listCustomerType();
}
