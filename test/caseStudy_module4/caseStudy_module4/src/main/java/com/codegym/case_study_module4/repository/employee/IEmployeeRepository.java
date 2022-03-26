package com.codegym.case_study_module4.repository.employee;


import com.codegym.case_study_module4.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
    Page<Employee> findByEmployeeNameContaining(String name, Pageable pageable);
}
