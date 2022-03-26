package com.codegym.case_study_module4.service.contract;

import com.codegym.case_study_module4.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractDetailService {
    Page<ContractDetail> findAll(Pageable pageable);
}
