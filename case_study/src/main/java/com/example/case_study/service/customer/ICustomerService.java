package com.example.case_study.service.customer;

import com.example.case_study.model.customer.Customer;
import com.example.case_study.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService extends IGeneralService <Customer>{
    Customer findById(String id);

    List<CustomerType> listCustomerType();

}
