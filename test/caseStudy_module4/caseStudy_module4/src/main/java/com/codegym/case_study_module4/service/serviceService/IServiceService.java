package com.codegym.case_study_module4.service.serviceService;

import com.codegym.case_study_module4.model.Service1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceService {
    Page<Service1> findAll(Pageable pageable);
    Service1 findById(Integer id);
    void save(Service1 service);
    void remove(Service1 service);
    Page<Service1> search(String name, Pageable pageable);
}
