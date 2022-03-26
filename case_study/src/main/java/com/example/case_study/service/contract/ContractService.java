package com.example.case_study.service.contract;

import com.example.case_study.model.contract.Contract;
import com.example.case_study.model.customer.Customer;
import com.example.case_study.model.employee.Employee;
import com.example.case_study.model.service.Service;
import com.example.case_study.repository.contract.IContractRepository;
import com.example.case_study.repository.customer.ICustomerRepository;
import com.example.case_study.repository.employee.IEmployeeRepository;
import com.example.case_study.repository.service.IServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ContractService implements IContractService{

    @Autowired
    private IContractRepository contractRepository;

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Contract findById(String id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
       contractRepository.save(contract);
    }

//    @Override
//    public void remove(String id) {
//        Contract contract = this.findById(id);
//        contract.setFlag(false);
//        save(contract);
//    }

    @Override
    public List<Employee> listEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Customer> listCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public List<Service> listService() {
        return serviceRepository.findAll();
    }
}
