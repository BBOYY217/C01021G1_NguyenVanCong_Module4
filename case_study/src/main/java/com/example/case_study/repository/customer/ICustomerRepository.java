package com.example.case_study.repository.customer;

import com.example.case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository <Customer,String> {
    @Query(value = "select * from  customer " +
            "inner join customer_type on customer.customer_type_id = customer_type.customer_type_id " +
            "where (customer_name like concat('%',:keyword,'%') " +
            "or  customer_id like concat('%',:keyword,'%')  " +
            "or customer_type_name like concat('%',:keyword,'%') " +
            "or customer_name like concat('%',:keyword,'%') " +
            "or customer_birth like concat('%',:keyword,'%')" +
            "or customer_gender like concat('%',:keyword,'%')" +
            "or customer_id_card like concat('%',:keyword,'%')" +
            "or customer_phone like concat('%',:keyword,'%')" +
            "or customer_email like concat('%',:keyword,'%')" +
            "or customer_address like concat('%',:keyword,'%')) and flag = 1", nativeQuery = true)
    Page<Customer> findAllByKeyWord(@Param("keyword") String keyword, Pageable pageable);
}
