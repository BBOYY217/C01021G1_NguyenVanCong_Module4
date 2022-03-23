package com.example.case_study.repository.service;

import com.example.case_study.model.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
}
