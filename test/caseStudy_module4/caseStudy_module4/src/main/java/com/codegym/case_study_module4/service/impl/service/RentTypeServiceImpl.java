package com.codegym.case_study_module4.service.impl.service;

import com.codegym.case_study_module4.model.RentType;
import com.codegym.case_study_module4.repository.service.IRentTypeRepository;
import com.codegym.case_study_module4.service.serviceService.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public Iterable<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
