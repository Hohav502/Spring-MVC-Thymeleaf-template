package com.example.students.repository;

import com.example.students.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    List<Student> findAll();
    Optional<Student>findById(int id);
    Student save(Student student);
    void delete(Student student);

    void deleteById(int id);
}
