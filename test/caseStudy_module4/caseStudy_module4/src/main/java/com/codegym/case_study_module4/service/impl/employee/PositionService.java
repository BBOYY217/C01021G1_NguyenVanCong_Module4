package com.codegym.case_study_module4.service.impl.employee;

import com.codegym.case_study_module4.model.Position;
import com.codegym.case_study_module4.repository.employee.IPositionRepository;
import com.codegym.case_study_module4.service.employeeService.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public Iterable<Position> findAll() {
        return positionRepository.findAll();
    }
}
