package com.example.case_study.service.contract;

import com.example.case_study.model.contract.AttachService;
import com.example.case_study.model.contract.Contract;
import com.example.case_study.model.contract.ContractDetail;
import com.example.case_study.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);
    Service findById(String id);
    void save(Service service);
    void remove(String id);
}
