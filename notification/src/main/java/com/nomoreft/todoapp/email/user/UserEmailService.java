package com.nomoreft.todoapp.email.user;

import com.nomoreft.todoapp.email.EmailSender;
import org.springframework.stereotype.Service;

@Service
public class UserEmailService {
    private final EmailSender emailSender;

    public UserEmailService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendWelcomeEmail(String to) {
        emailSender.sendEmail("test@mail.com",to, "Welcome to our application", "...");
    }
}
