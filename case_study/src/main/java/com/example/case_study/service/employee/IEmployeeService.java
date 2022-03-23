package com.example.case_study.service.employee;

import com.example.case_study.model.employee.Division;
import com.example.case_study.model.employee.EducationDegree;
import com.example.case_study.model.employee.Employee;
import com.example.case_study.model.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAll(String keyword, Pageable pageable);
    Employee findById(String id);
    void save(Employee employee);
    void remove(String id);
    List<Division> listDivision();
    List<Position> listPosition();
    List<EducationDegree> listEducationDegree();
}
