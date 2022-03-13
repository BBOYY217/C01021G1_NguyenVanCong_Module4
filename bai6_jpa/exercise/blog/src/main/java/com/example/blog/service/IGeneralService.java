package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.List;

public interface IGeneralService<T> {
    List<Blog> findAll();
    Blog findById(Long id);
    void save(T t);
    void remove(Long id);
}
