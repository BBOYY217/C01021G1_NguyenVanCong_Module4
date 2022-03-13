package com.example.using_spring_jpa_store_procedure.service;

import com.example.using_spring_jpa_store_procedure.model.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}
