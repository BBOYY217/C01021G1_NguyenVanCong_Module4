package com.example.case_study.service.service;

import com.example.case_study.model.customer.CustomerType;
import com.example.case_study.model.service.RentType;
import com.example.case_study.model.service.Service;
import com.example.case_study.model.service.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    Page<Service> findAll(Pageable pageable);
    Service findById(String id);
    void save(Service service);
    void remove(String id);
    List<RentType> ListRentType();
    List<ServiceType> ListServiceType();
}
