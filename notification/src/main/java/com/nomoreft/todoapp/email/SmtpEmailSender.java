package com.nomoreft.todoapp.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SmtpEmailSender implements EmailSender {

    private final JavaMailSender mailSender;

    @Async
    @Override
    public void sendEmail(String from, String to, String subject, String body) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true); // HTML 지원

            mailSender.send(message);
            log.info("SMTP 이메일 전송 성공: to={}, subject={}", to, subject);
        } catch (MessagingException e) {
            log.error("SMTP 이메일 전송 실패: to={}, error={}", to, e.getMessage());
            throw new RuntimeException("이메일 전송 중 오류 발생", e);
        }
    }
}
