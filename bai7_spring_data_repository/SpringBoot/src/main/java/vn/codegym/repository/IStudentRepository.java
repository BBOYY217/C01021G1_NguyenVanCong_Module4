package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Student;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByName(String name); //Select * from Student where student.name = ?
    List<Student> findByNameContaining(String name);
    List<Student> findByNameContainingAndIdGreaterThanEqual(String name, int id); //tên tương đối và ID >= 2

    @Query(value = "select * from Student where name=:keyword", nativeQuery = true)
    List<Student> searchByName(@Param("keyword") String keyword);
}
