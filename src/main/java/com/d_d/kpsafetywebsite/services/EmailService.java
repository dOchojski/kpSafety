package com.d_d.kpsafetywebsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String name, String email, String phone, String message) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("klaudiasafetyy@gmail.com");
        mailMessage.setSubject("Nowa wiadomość z formularza kontaktowego KP");
        mailMessage.setText("Otrzymałeś nową wiadomość od: " + name
                + "\nE-mail: " + email
                + "\nTelefon: " + phone
                + "\nWiadomość: " + message);

        mailSender.send(mailMessage);
    }
}
