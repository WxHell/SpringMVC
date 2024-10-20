package com.springmvc.thymeleafdemo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${systems}")
    private List<String> systems;
    @Value("${countries}")
    private List<String> countries;
    @Value("${languages}")
    private List<String> languages;

   @GetMapping("/showStudentForm")
    public String showForm(Model theModel){
       Student theStudent = new Student();
       theModel.addAttribute("student",theStudent);
       theModel.addAttribute("countries",countries);
       theModel.addAttribute("languages",languages);
       theModel.addAttribute("system",systems);
        return "student-form";
    }
    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){

        System.out.println("theStudent: " + theStudent.getFirstName().toUpperCase() + " " +
                theStudent.getLastName().toUpperCase());
       return "student-confirmation";
    }
}
