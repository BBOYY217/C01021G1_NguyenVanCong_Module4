package com.example.case_study.service.customer;

import com.example.case_study.model.customer.Customer;
import com.example.case_study.model.customer.CustomerType;
import com.example.case_study.repository.customer.ICustomerRepository;
import com.example.case_study.repository.customer.ICustomerTypeIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private ICustomerTypeIdRepository customerTypeIdRepository;


    @Override
    public Page<Customer> findAll(String keyword, Pageable pageable) {
        return customerRepository.findAllByKeyWord(keyword, pageable);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(String id) {
        Customer customer = this.findById(id);
        customer.setFlag(false);
        save(customer);
    }

    @Override
    public List<CustomerType> listCustomerType() {
        return customerTypeIdRepository.findAll();
    }
}
