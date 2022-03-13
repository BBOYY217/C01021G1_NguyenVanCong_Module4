package com.example.customer_management.repository;

import com.example.customer_management.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProvinceRepository extends PagingAndSortingRepository<Province,Long> {
}
