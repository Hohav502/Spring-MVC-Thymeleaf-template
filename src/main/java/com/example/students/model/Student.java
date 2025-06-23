package com.example.students.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Student {
    private int id;
    private String name;
    private String gender; // Moved earlier
    private int age;
    private String grade;

    public Student(int id, String name, String gender, int age, String grade) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.grade = grade;
    }
}