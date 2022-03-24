package com.example.case_study.repository.service;

import com.example.case_study.model.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service,String> {
}
