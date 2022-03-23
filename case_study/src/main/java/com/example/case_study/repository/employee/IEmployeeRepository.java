package com.example.case_study.repository.employee;

import com.example.case_study.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee,String> {
    @Query(value = "SELECT * FROM  employee " +
            " join division on employee.division_id = division.division_id " +
            " join education_degree on employee.education_degree_id = education_degree.education_degree_id " +
            " join position on employee.position_id = position.position_id " +
            "where (employee_name like concat('%',:keyword,'%') " +
            " or employee_id like concat('%',:keyword,'%')" +
            " or employee_birth like concat('%',:keyword,'%'))and flag = 1", nativeQuery = true)
//            " or employee_id_card like concat('%',:keyword,'%') " +
//            " or employee_phone like concat('%',:keyword,'%') " +
//            " or employee_salary like concat('%',:keyword,'%') " +
//            " or employee_email like concat('%',:keyword,'%') " +
//            " or employee_address like concat('%',:keyword,'%')" +
//            " or division_name like concat('%',:keyword,'%')\n" +
//            " or education_degree_name like concat('%',:keyword,'%')" +
//            " or position_name like concat('%',:keyword,'%'))and flag = 1", nativeQuery = true)
    Page<Employee> findAllByKeyWord(@Param("keyword") String keyword, Pageable pageable);
}
