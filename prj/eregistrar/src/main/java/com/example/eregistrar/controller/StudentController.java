package com.example.eregistrar.controller;

import com.example.eregistrar.model.Student;
import com.example.eregistrar.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/list")
    public String listStudents(Model model, @RequestParam(required = false) String keyword) {
        List<Student> students;
        if (keyword != null && !keyword.trim().isEmpty()) {
            students = studentRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(keyword, keyword);
            model.addAttribute("keyword", keyword);
        } else {
            students = studentRepository.findAll();
        }
        model.addAttribute("students", students);
        return "students/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "students/form";
        }
        studentRepository.save(student);
        return "redirect:/students/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            return "redirect:/students/list";
        }
        model.addAttribute("student", student.get());
        return "students/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "redirect:/students/list";
    }
}
