package com.example.case_study.service.employee;

import com.example.case_study.model.employee.Division;
import com.example.case_study.model.employee.EducationDegree;
import com.example.case_study.model.employee.Employee;
import com.example.case_study.model.employee.Position;
import com.example.case_study.repository.employee.IDivisionRepository;
import com.example.case_study.repository.employee.IEducationDegreeRepository;
import com.example.case_study.repository.employee.IEmployeeRepository;
import com.example.case_study.repository.employee.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private IDivisionRepository divisionRepository;

    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;

    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public Page<Employee> findAll(String keyword, Pageable pageable) {
        return employeeRepository.findAllByKeyWord(keyword, pageable);
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(String id) {
        Employee employee = this.findById(id);
        employee.setFlag(false);
        save(employee);
    }

    @Override
    public List<Division> listDivision() {
        return divisionRepository.findAll();
    }

    @Override
    public List<Position> listPosition() {
        return positionRepository.findAll();
    }

    @Override
    public List<EducationDegree> listEducationDegree() {
        return educationDegreeRepository.findAll();
    }
}
