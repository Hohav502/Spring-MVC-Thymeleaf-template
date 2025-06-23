package com.example.students.repository;

import com.example.students.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    public final List<Student> students;
    private int nextId;

    public StudentRepository(List<Student>students) {
        this.students = students;
        this.nextId = students.size();
    }
    public List<Student> findAll(){
        return students;
    }
    public void save(Student student){
        student.setId(nextId++);
        students.add(student);
    }
    public Student findById(int id){
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }
    public void update(Student student){
        for (int i = 0; i < students.size(); i++) {
            if(student.getId() == students.get(i).getId()){
                students.set(i, student);
                return;
            }
        }
    }
    public void deleteById(int id){
        students.removeIf(s ->s.getId() == id);
    }
}
