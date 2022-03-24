package com.example.case_study.service.contract;

import com.example.case_study.model.contract.AttachService;
import com.example.case_study.model.contract.Contract;
import com.example.case_study.model.contract.ContractDetail;
import com.example.case_study.model.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ContractService implements IContractService{

    @Autowired
    private IContractService contractService;

    @A

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Service findById(String id) {
        return null;
    }

    @Override
    public void save(Service service) {

    }

    @Override
    public void remove(String id) {

    }
}
