package com.example.blog.service.blog;

import com.example.blog.model.Blog;
import com.example.blog.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService<Blog> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByTitleContaining(String name, Pageable pageable);
}
