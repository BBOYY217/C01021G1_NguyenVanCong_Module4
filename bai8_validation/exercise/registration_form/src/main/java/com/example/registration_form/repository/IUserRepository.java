package com.example.registration_form.repository;

import com.example.registration_form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends JpaRepository<User,Long> {
    @Query(value = "SELECT * FROM user  " +
            "where (firstName like concat('%',:keyword,'%') " +
            "or lastName like concat('%',:keyword,'%')" +
            "or age like concat('%',:keyword,'%')" +
            "or email like concat('%',:keyword,'%') " +
            "or phone like concat('%',:keyword,'%')) and flag = 1 ",nativeQuery = true)
    Page<User> findAllByKeyWord(@Param("keyword") String keyword, Pageable pageable);

}
