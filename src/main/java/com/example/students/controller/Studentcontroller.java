package com.example.students.controller;
import com.example.students.model.Student;

import com.example.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
@Controller
@RequestMapping("/students")
public class Studentcontroller {

    private final StudentService service;
    @Autowired
    public Studentcontroller(StudentService service) {
        this.service = service;
    }
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("students", service.getAllStudents());
        return "index";
    }
    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("student",new Student());
        return "add-student";
    }
    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student){
        service.addStudent(student);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public  String showEditForm(@PathVariable int id, Model model){
       Student student = service.getStudentById(id);
       model.addAttribute("student",student);
       return "edit-student";
    }
    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student student){
        service.updateStudent(student);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        service.deleteStudentById(id);
        return "redirect:/";
    }
}

