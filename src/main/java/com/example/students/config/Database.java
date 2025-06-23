package com.example.students.config;

import com.example.students.model.Student;
import com.example.students.repository.StudentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class Database {
    private final List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Alice Johnson", 15, "Grade 10"),
            new Student(2, "Bob Smith", 14, "Grade 9"),
            new Student(3, "Charlie Brown", 16, "Grade 11"),
            new Student(4, "Diana Prince", 17, "Grade 12"),
            new Student(5, "Ethan Hunt", 15, "Grade 10"),
            new Student(6, "Fiona Gallagher", 14, "Grade 9"),
            new Student(7, "George Washington", 16, "Grade 11"),
            new Student(8, "Hannah Baker", 17, "Grade 12"),
            new Student(9, "Ian Malcolm", 15, "Grade 10"),
            new Student(10, "Julia Roberts", 14, "Grade 9")
    ));
    @Bean
    public List<Student> studentsList(){
        return students;
    }
    @Bean
    public StudentRepository studentRepository() {
        return new StudentRepository() {
            @Override
            public List<Student> findAll() {
                return new ArrayList<>(students); // Return a copy to prevent direct modification
            }

            @Override
            public Optional<Student> findById(int id) {
                return students.stream().filter(s -> s.getId() == id).findFirst();
            }

            @Override
            public Student save(Student student) {
                if (student.getId() == 0) {
                    int newId = students.stream().mapToInt(Student::getId).max().orElse(0) + 1;
                    student.setId(newId);
                    students.add(student);
                } else { // Update existing student
                    students.removeIf(s -> s.getId() == student.getId());
                    students.add(student);
                }
                return student;
            }

            @Override
            public void delete(Student student) {

            }

            @Override
            public void deleteById(int id) {
                students.removeIf(s -> s.getId() == id);
            }
        };
    }
}
