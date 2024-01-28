package com.example.simplewebapp.controller;

import com.example.simplewebapp.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String hello(Model model) {
        Message message = new Message("Hello, Spring Boot!");
        model.addAttribute("message", message);
        return "index";
    }
}
