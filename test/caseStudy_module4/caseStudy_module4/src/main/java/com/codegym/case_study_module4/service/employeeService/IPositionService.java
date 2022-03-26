package com.codegym.case_study_module4.service.employeeService;


import com.codegym.case_study_module4.model.Position;

import java.util.List;

public interface IPositionService {
    Iterable<Position> findAll();
}
