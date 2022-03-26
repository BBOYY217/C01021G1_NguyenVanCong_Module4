package com.codegym.case_study_module4.service.impl.service;

import com.codegym.case_study_module4.model.Service1;
import com.codegym.case_study_module4.repository.service.IServiceRepository;
import com.codegym.case_study_module4.service.serviceService.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class Service1ServiceImpl implements IServiceService {
    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public Page<Service1> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Service1 findById(Integer id) {
        return serviceRepository.findById(id).get();
    }

    @Override
    public void save(Service1 service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(Service1 service) {
        serviceRepository.delete(service);
    }

    @Override
    public Page<Service1> search(String name, Pageable pageable) {
        return serviceRepository.findByServiceNameContaining(name, pageable);
    }
}
