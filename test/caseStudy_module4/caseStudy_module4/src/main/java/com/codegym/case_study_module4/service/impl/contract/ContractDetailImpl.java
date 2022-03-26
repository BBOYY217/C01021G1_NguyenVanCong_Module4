package com.codegym.case_study_module4.service.impl.contract;


import com.codegym.case_study_module4.model.ContractDetail;
import com.codegym.case_study_module4.repository.contract.IContractDetailRepository;
import com.codegym.case_study_module4.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailImpl implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }
}
