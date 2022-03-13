package com.example.blog.repository.blog;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBlogRepository extends PagingAndSortingRepository<Blog,Long> {
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
}
