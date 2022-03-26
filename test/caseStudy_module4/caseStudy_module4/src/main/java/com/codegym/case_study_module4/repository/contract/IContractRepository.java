package com.codegym.case_study_module4.repository.contract;

import com.codegym.case_study_module4.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IContractRepository extends PagingAndSortingRepository<Contract, Integer> {
}
