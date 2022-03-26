package com.codegym.case_study_module4.repository.service;

import com.codegym.case_study_module4.model.RentType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IRentTypeRepository extends PagingAndSortingRepository<RentType, Integer> {
}
