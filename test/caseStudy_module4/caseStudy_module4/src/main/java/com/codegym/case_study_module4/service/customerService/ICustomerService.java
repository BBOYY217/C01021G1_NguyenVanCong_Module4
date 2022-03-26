package com.codegym.case_study_module4.service.customerService;


import com.codegym.case_study_module4.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Integer id);
    void remove(Customer customer);
    void save(Customer customer);
    Page<Customer> searchByName(String name, Pageable pageable);
}
