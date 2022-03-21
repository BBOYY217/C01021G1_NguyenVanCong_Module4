package com.example.case_study.repository.customer;

import com.example.case_study.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeIdRepository extends JpaRepository<CustomerType,Integer> {

}
