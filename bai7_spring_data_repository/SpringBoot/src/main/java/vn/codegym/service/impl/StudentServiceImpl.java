package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Student;
import vn.codegym.repository.IStudentRepository;
import vn.codegym.service.IStudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository repository;

    @Override
    public List<Student> findAll() {
       return repository.findAll();
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void save(Student student) {
        repository.save(student);
    }

    @Override
    public Student findById(int id) {
//
//        Optional<Student> student =  repository.findById(id);
//        if(student.isPresent()){
//            return student.get();
//        } else {
//            return null;
//        }

        return repository.findById(id).orElse(null);

    }

    @Override
    public List<Student> searchByName(String name) {
//        return repository.findByName(name);
//        return repository.findByNameContaining(name);
//        return repository.findByNameContainingAndIdGreaterThanEqual(name,2);
        return repository.searchByName(name);
    }
}
