package com.example.registration_form.service;

import com.example.registration_form.model.User;
import com.example.registration_form.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

//    @Override
//    public Iterable findAll() {
//        return userRepository.findAll();
//    }

    @Override
    public Optional findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<User> findAllByKeyWord(String keyword, Pageable pageable) {
        return userRepository.findAllByKeyWord(keyword, pageable);
    }
}
