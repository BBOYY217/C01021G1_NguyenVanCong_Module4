package com.example.registration_form.service;

import com.example.registration_form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IUserService extends IGeneralService<User> {
    Page<User> findAllByKeyWord(@Param("keyword") String keyword, Pageable pageable);
}
