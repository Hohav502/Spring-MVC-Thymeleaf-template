package com.example.students.service;

import com.example.students.model.Student;
import com.example.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

//    private final List<Student> students;
//
//    public StudentService(List<Student> students) {
//        this.students = students;
//    }
//
//    public List<Student> getAllStudents() {
//        return students;
//    }
//
//    public Student getStudentById(int id) {
//        return students.stream()
//                .filter(s -> s.getId() == id)
//                .findFirst()
//                .orElse(null);
//    }
//
//    public void addStudent(Student student) {
//        student.setId(students.size() + 1);
//        students.add(student);
//    }
//
//    public void updateStudent(Student updatedStudent) {
//        for (int i = 0; i < students.size(); i++) {
//            if (students.get(i).getId() == updatedStudent.getId()) {
//                students.set(i, updatedStudent);
//                return;
//            }
//        }
//    }
//
//    public void deleteStudentById(int id) {
//        students.removeIf(s -> s.getId() == id);
//    }

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student>getAllStudents() {
        return studentRepository.findAll();
    }
    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
