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
            new Student(1, "Chan Sophea", "Female", 15, "Grade 10"),
            new Student(2, "Sok Vuthy", "Male", 14, "Grade 9"),
            new Student(3, "Kim Ratanak", "Male", 16, "Grade 11"),
            new Student(4, "Srey Dara", "Female", 17, "Grade 12"),
            new Student(5, "Leng Nita", "Female", 15, "Grade 10"),
            new Student(6, "Hun Borey", "Male", 14, "Grade 9"),
            new Student(7, "Vong Makara", "Male", 16, "Grade 11"),
            new Student(8, "Meas Kunthea", "Female", 17, "Grade 12"),
            new Student(9, "Chea Piseth", "Male", 15, "Grade 10"),
            new Student(10, "Yim Sreyleak", "Female", 14, "Grade 9"),
            new Student(11, "Ly Socheat", "Male", 15, "Grade 10"),
            new Student(12, "Khim Dany", "Female", 16, "Grade 11"),
            new Student(13, "Tep Sovan", "Male", 17, "Grade 12"),
            new Student(14, "Nuon Chenda", "Female", 15, "Grade 10"),
            new Student(15, "Eang Nara", "Male", 14, "Grade 9"),
            new Student(16, "Chum Linda", "Female", 16, "Grade 11"),
            new Student(17, "Sim Vanda", "Female", 17, "Grade 12"),
            new Student(18, "Keo Rotha", "Male", 15, "Grade 10"),
            new Student(19, "Ouk Kanha", "Female", 14, "Grade 9"),
            new Student(20, "Prum Mony", "Female", 16, "Grade 11"),
            new Student(21, "Hem Bopha", "Female", 17, "Grade 12"),
            new Student(22, "Men Kimsan", "Male", 15, "Grade 10"),
            new Student(23, "Pen Sitha", "Male", 14, "Grade 9"),
            new Student(24, "Yorn Pich", "Male", 16, "Grade 11"),
            new Student(25, "Lay Reaksmey", "Male", 17, "Grade 12"),
            new Student(26, "Sann Nisay", "Male", 15, "Grade 10"),
            new Student(27, "Touch Malis", "Female", 14, "Grade 9"),
            new Student(28, "Samith Ravy", "Male", 16, "Grade 11"),
            new Student(29, "Chantha Neary", "Female", 17, "Grade 12"),
            new Student(30, "Ros Sopheak", "Male", 15, "Grade 10"),
            new Student(31, "Kak Sovann", "Male", 14, "Grade 9"),
            new Student(32, "Khiev Sokha", "Male", 16, "Grade 11"),
            new Student(33, "Phat Leakena", "Female", 17, "Grade 12"),
            new Student(34, "Van Theara", "Male", 15, "Grade 10"),
            new Student(35, "Seng Navy", "Female", 14, "Grade 9"),
            new Student(36, "Rin Monika", "Female", 16, "Grade 11"),
            new Student(37, "Heng Visal", "Male", 17, "Grade 12"),
            new Student(38, "Phoeun Sambath", "Male", 15, "Grade 10"),
            new Student(39, "Mao Sreynich", "Female", 14, "Grade 9"),
            new Student(40, "Lim Dara", "Male", 16, "Grade 11"),
            new Student(41, "Chey Vicheka", "Female", 17, "Grade 12"),
            new Student(42, "Khun Khemara", "Male", 15, "Grade 10"),
            new Student(43, "Pov Charya", "Female", 14, "Grade 9"),
            new Student(44, "Neang Visoth", "Male", 16, "Grade 11"),
            new Student(45, "Long Kunthea", "Female", 17, "Grade 12"),
            new Student(46, "Som Borey", "Male", 15, "Grade 10"),
            new Student(47, "Khieu Sreymao", "Female", 14, "Grade 9"),
            new Student(48, "Ou Vannak", "Male", 16, "Grade 11"),
            new Student(49, "Heang Chantha", "Female", 17, "Grade 12"),
            new Student(50, "Tith Sovandy", "Female", 15, "Grade 10")

    ));

    @Bean
    public List<Student> studentList() {
        return students;
    }

    @Bean
    public StudentRepository studentRepository() {
        return new StudentRepository() {
            @Override
            public List<Student> findAll() {
                return new ArrayList<>(students);
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
                } else {
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