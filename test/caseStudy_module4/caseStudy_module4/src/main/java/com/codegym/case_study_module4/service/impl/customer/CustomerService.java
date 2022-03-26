package com.codegym.case_study_module4.service.impl.customer;

import com.codegym.case_study_module4.model.Customer;
import com.codegym.case_study_module4.repository.customer.ICustomerRepository;
import com.codegym.case_study_module4.service.customerService.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void remove(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> searchByName(String name, Pageable pageable) {
        return customerRepository.findByCustomerNameContaining(name, pageable);
    }
}
