package com.springmvc.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpResponse;

@Controller
public class HelloWorldController {
    @GetMapping("/showForm")
    public String showFrom(){
        return "helloWorld-form";
    }
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloWorld";
    }
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){
        String theName=request.getParameter("studentName");
        theName=theName.toUpperCase();
        String result = "Yo! " + theName;
        model.addAttribute("message",result);
        return "helloWorld";
    }
    @GetMapping("/processFormVersionTree")
    public String processFormVersionThree(@RequestParam("studentName")String theName, Model model){

        theName=theName.toUpperCase();
        String result = "Hey My Friend v3! " + theName;
        model.addAttribute("message",result);
        return "helloWorld";
    }
}

