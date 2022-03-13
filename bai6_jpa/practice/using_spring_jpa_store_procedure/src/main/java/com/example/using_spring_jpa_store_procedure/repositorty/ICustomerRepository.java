package com.example.using_spring_jpa_store_procedure.repositorty;

import com.example.using_spring_jpa_store_procedure.model.Customer;

import java.beans.Customizer;

public interface ICustomerRepository {
    boolean insertWithStoredProcedure(Customer customer);
}
