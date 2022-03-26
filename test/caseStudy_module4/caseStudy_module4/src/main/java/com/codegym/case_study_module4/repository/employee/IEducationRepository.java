package com.codegym.case_study_module4.repository.employee;

import com.codegym.case_study_module4.model.Education;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IEducationRepository extends PagingAndSortingRepository<Education, Integer> {
}
