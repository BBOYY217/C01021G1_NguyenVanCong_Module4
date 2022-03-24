package com.example.case_study.repository.contract;

import com.example.case_study.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Long> {
}
