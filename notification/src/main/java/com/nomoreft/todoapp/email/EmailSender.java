package com.nomoreft.todoapp.email;

public interface EmailSender {
    void sendEmail(String from, String to, String subject, String body);
}