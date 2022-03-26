package com.codegym.case_study_module4.service.impl.employee;

import com.codegym.case_study_module4.model.Employee;
import com.codegym.case_study_module4.repository.employee.IEmployeeRepository;
import com.codegym.case_study_module4.service.employeeService.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public Page<Employee> searchByName(String name, Pageable pageable) {
        return employeeRepository.findByEmployeeNameContaining(name, pageable);
    }
}
