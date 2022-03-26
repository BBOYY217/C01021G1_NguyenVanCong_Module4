package com.codegym.case_study_module4.service.contract;

import com.codegym.case_study_module4.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);
    Contract findById(Integer id);
    void save(Contract contract);
    void remove(Contract contract);
}
