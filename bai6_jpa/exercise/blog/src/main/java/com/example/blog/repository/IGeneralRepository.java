package com.example.blog.repository;

import com.example.blog.model.Blog;

import java.util.List;

public interface IGeneralRepository<T>{
    List<Blog> findAll();
    Blog findById(Long id);
    void save(T t);
    void remove(Long id);
}
