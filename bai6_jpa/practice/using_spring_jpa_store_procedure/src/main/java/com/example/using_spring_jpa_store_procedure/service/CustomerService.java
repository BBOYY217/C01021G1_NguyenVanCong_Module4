package com.example.using_spring_jpa_store_procedure.service;

import com.example.using_spring_jpa_store_procedure.model.Customer;
import com.example.using_spring_jpa_store_procedure.repositorty.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        return customerRepository.insertWithStoredProcedure(customer);
    }
}
