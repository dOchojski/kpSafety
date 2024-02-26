package com.d_d.kpsafetywebsite.controller;

import com.d_d.kpsafetywebsite.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    private final EmailService emailService;

    @Autowired
    public WebController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }


    @PostMapping("/contact")
    public String handleContactForm(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String message) {

        emailService.sendEmail(name, email, phone, message);
        return "redirect:/";
    }

}