package com.example.case_study.service.contract;

import com.example.case_study.model.contract.Contract;
import com.example.case_study.model.customer.Customer;
import com.example.case_study.model.employee.Employee;
import com.example.case_study.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);
    Contract findById(String id);
    void save(Contract contract);
//    void remove(String id);
    List<Employee> listEmployee();
    List<Customer> listCustomer();
    List<Service> listService();
}
