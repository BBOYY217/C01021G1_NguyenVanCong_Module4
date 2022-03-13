package com.example.blog.repository.category;

import com.example.blog.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
