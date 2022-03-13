package com.example.registration_form.service;

import com.example.registration_form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IGeneralService<T> {
    Page<T> findAllByKeyWord( String keyword, Pageable pageable);
    Optional<T> findById(Long id);
    void save(T t);
    void remove(Long id);
}
