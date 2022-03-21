package com.example.case_study.service;

import com.example.case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGeneralService<T> {
    Page<T> findAll(String keyword, Pageable pageable);
    Optional<T> findById(Long id);
    void save(T t);
    void remove(Long id);
}
