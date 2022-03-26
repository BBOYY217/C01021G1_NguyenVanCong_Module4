package com.codegym.case_study_module4.repository.customer;

import com.codegym.case_study_module4.model.CustomerType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ICustomerTypeRepo extends PagingAndSortingRepository<CustomerType, Integer> {

}
