package com.example.students.config;

import com.example.students.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Database {
    @Bean
    public List<Student> studentList() {
        return new ArrayList<>(List.of(
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
    }
}
