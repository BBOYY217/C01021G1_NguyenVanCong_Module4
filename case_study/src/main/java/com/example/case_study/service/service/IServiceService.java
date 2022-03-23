package com.example.case_study.service.service;

import com.example.case_study.model.customer.Customer;
import com.example.case_study.model.customer.CustomerType;
import com.example.case_study.model.service.Service;

import java.util.List;

public interface IServiceService {
    Service findById(int id);
    void save(Service service);
    void remove(int id);
    List<CustomerType> listCustomerType();
}
