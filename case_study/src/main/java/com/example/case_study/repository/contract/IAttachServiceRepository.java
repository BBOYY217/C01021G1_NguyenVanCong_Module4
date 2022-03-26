package com.example.case_study.repository.contract;

import com.example.case_study.model.contract_detail.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachServiceRepository extends JpaRepository<AttachService,Long> {
}
