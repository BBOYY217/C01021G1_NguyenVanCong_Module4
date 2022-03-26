package com.codegym.case_study_module4.service.user;

import com.codegym.case_study_module4.model.user.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
}
