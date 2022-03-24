package com.example.case_study.repository.contract;

import com.example.case_study.model.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachServiceRepository extends JpaRepository<AttachService,Long> {
}
