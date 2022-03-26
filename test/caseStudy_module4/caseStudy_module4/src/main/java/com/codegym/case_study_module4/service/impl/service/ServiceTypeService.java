package com.codegym.case_study_module4.service.impl.service;

import com.codegym.case_study_module4.model.ServiceType;
import com.codegym.case_study_module4.repository.service.IServiceTypeRepository;
import com.codegym.case_study_module4.service.serviceService.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

@Service
public class ServiceTypeService implements IServiceTypeService {
    @Autowired
    private IServiceTypeRepository serviceTypeRepository;

    @Override
    public Iterable<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
