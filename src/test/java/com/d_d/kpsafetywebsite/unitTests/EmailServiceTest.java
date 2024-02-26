package com.d_d.kpsafetywebsite.unitTests;

import com.d_d.kpsafetywebsite.services.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.verify;

public class EmailServiceTest {
    @Mock
    private JavaMailSender mailSender;

    private EmailService emailService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        emailService = new EmailService(mailSender);
    }

    @Test
    void sendEmail() {
        String name = "Piotr Kowalski";
        String email = "test@gmail.com";
        String phone = "123456789";
        String message = "Test";

        emailService.sendEmail(name, email, phone, message);

        SimpleMailMessage expectedMailMessage = new SimpleMailMessage();
        expectedMailMessage.setTo("klaudiasafetyy@gmail.com");
        expectedMailMessage.setSubject("Nowa wiadomość z formularza kontaktowego KP");
        expectedMailMessage.setText("Otrzymałeś nową wiadomość od: " + name + "\nE-mail: " + email + "\nTelefon: " + phone + "\nWiadomość: " + message);

        verify(mailSender).send(expectedMailMessage);
    }
}
