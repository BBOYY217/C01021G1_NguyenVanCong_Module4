package com.example.case_study.service.service;

import com.example.case_study.model.customer.Customer;
import com.example.case_study.model.customer.CustomerType;
import com.example.case_study.model.service.RentType;
import com.example.case_study.model.service.Service;
import com.example.case_study.model.service.ServiceType;
import com.example.case_study.repository.service.IRentTypeRepository;
import com.example.case_study.repository.service.IServiceRepository;
import com.example.case_study.repository.service.IServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService implements IServiceService{
    @Autowired
    private IServiceRepository serviceRepository;

    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Autowired
    private IServiceTypeRepository serviceTypeRepository;

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Service findById(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(String id) {
        Service service = this.findById(id);
        service.setFlag(false);
        save(service);
    }

    @Override
    public List<RentType> ListRentType() {
        return rentTypeRepository.findAll();
    }

    @Override
    public List<ServiceType> ListServiceType() {
        return serviceTypeRepository.findAll();
    }

}
