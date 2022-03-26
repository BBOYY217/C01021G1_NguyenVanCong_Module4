package com.codegym.case_study_module4.repository.service;

import com.codegym.case_study_module4.model.Service1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IServiceRepository extends PagingAndSortingRepository<Service1, Integer> {
    Page<Service1> findByServiceNameContaining(String name, Pageable pageable);
}
