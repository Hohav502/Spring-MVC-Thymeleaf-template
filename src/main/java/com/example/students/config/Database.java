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
            new Student(1001, "Chan Sophea", "Female", 15, "Grade 10"),
            new Student(1002, "Sok Vuthy", "Male", 14, "Grade 9"),
            new Student(1003, "Kim Ratanak", "Male", 16, "Grade 11"),
            new Student(1004, "Srey Dara", "Female", 17, "Grade 12"),
            new Student(1005, "Leng Nita", "Female", 15, "Grade 10"),
            new Student(1006, "Hun Borey", "Male", 14, "Grade 9"),
            new Student(1007, "Vong Makara", "Male", 16, "Grade 11"),
            new Student(1008, "Meas Kunthea", "Female", 17, "Grade 12"),
            new Student(1009, "Chea Piseth", "Male", 15, "Grade 10"),
            new Student(1010, "Yim Sreyleak", "Female", 14, "Grade 9"),
            new Student(1011, "Ly Socheat", "Male", 15, "Grade 10"),
            new Student(1012, "Khim Dany", "Female", 16, "Grade 11"),
            new Student(1013, "Tep Sovan", "Male", 17, "Grade 12"),
            new Student(1014, "Nuon Chenda", "Female", 15, "Grade 10"),
            new Student(1015, "Eang Nara", "Male", 14, "Grade 9"),
            new Student(1016, "Chum Linda", "Female", 16, "Grade 11"),
            new Student(1017, "Sim Vanda", "Female", 17, "Grade 12"),
            new Student(1018, "Keo Rotha", "Male", 15, "Grade 10"),
            new Student(1019, "Ouk Kanha", "Female", 14, "Grade 9"),
            new Student(1020, "Prum Mony", "Female", 16, "Grade 11"),
            new Student(1021, "Hem Bopha", "Female", 17, "Grade 12"),
            new Student(1022, "Men Kimsan", "Male", 15, "Grade 10"),
            new Student(1023, "Pen Sitha", "Male", 14, "Grade 9"),
            new Student(1024, "Yorn Pich", "Male", 16, "Grade 11"),
            new Student(1025, "Lay Reaksmey", "Male", 17, "Grade 12"),
            new Student(1026, "Sann Nisay", "Male", 15, "Grade 10"),
            new Student(1027, "Touch Malis", "Female", 14, "Grade 9"),
            new Student(1028, "Samith Ravy", "Male", 16, "Grade 11"),
            new Student(1029, "Chantha Neary", "Female", 17, "Grade 12"),
            new Student(1030, "Ros Sopheak", "Male", 15, "Grade 10"),
            new Student(1031, "Kak Sovann", "Male", 14, "Grade 9"),
            new Student(1032, "Khiev Sokha", "Male", 16, "Grade 11"),
            new Student(1033, "Phat Leakena", "Female", 17, "Grade 12"),
            new Student(1034, "Van Theara", "Male", 15, "Grade 10"),
            new Student(1035, "Seng Navy", "Female", 14, "Grade 9"),
            new Student(1036, "Rin Monika", "Female", 16, "Grade 11"),
            new Student(1037, "Heng Visal", "Male", 17, "Grade 12"),
            new Student(1038, "Phoeun Sambath", "Male", 15, "Grade 10"),
            new Student(1039, "Mao Sreynich", "Female", 14, "Grade 9"),
            new Student(1040, "Lim Dara", "Male", 16, "Grade 11"),
            new Student(1041, "Chey Vicheka", "Female", 17, "Grade 12"),
            new Student(1042, "Khun Khemara", "Male", 15, "Grade 10"),
            new Student(1043, "Pov Charya", "Female", 14, "Grade 9"),
            new Student(1044, "Neang Visoth", "Male", 16, "Grade 11"),
            new Student(1045, "Long Kunthea", "Female", 17, "Grade 12"),
            new Student(1046, "Som Borey", "Male", 15, "Grade 10"),
            new Student(1047, "Khieu Sreymao", "Female", 14, "Grade 9"),
            new Student(1048, "Ou Vannak", "Male", 16, "Grade 11"),
            new Student(1049, "Heang Chantha", "Female", 17, "Grade 12"),
            new Student(1050, "Tith Sovandy", "Female", 15, "Grade 10")


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