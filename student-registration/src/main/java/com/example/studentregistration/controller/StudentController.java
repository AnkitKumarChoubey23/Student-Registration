package com.example.studentregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.studentregistration.model.Student;
import com.example.studentregistration.service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute Student student) {
        service.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String viewStudents(Model model, HttpSession session) {
        model.addAttribute("students", service.getAllStudents());
        model.addAttribute("role", session.getAttribute("role"));
        return "student-list";
    }

    // 🔹 EDIT STUDENT
    @GetMapping("/editStudent/{id}")
    public String editStudent(@PathVariable int id, Model model) {
        Student student = service.getStudentById(id);
        model.addAttribute("student", student);
        return "edit-student";
    }

    // 🔹 UPDATE STUDENT
    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute Student student) {
        service.saveStudent(student);
        return "redirect:/students";
    }

    // 🔹 DELETE STUDENT
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return "redirect:/students";
    }
}
