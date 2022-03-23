package com.example.case_study.repository.service;

import com.example.case_study.model.service.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType,Integer> {
}
