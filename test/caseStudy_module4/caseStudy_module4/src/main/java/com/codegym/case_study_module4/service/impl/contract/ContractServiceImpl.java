package com.codegym.case_study_module4.service.impl.contract;

import com.codegym.case_study_module4.model.Contract;
import com.codegym.case_study_module4.repository.contract.IContractRepository;
import com.codegym.case_study_module4.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Contract findById(Integer id) {
        return contractRepository.findById(id).get();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(Contract contract) {
        contractRepository.delete(contract);
    }
}
