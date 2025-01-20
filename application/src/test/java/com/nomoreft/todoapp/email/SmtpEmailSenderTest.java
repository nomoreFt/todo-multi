package com.nomoreft.todoapp.email;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@SpringBootTest
class SmtpEmailSenderTest {

    @Autowired
    private EmailSender emailSender;

    private static final int TOTAL_EMAILS = 100;

    @Test
    void sendEmailsAsync_100Times() {
        String from = "your-email@gmail.com";
        String to = "receiver-email@example.com";
        String subject = "📧 성능 테스트 - 비동기 이메일 전송";
        String body = "<h3>이메일 전송 테스트</h3><p>비동기 로직이 정상 동작하는지 확인하세요.</p>";

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < TOTAL_EMAILS; i++) {
            final int emailNumber = i + 1;
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                emailSender.sendEmail(from, to, subject + " #" + emailNumber, body);
                System.out.println("✅ 이메일 전송 성공: " + emailNumber);
            });

            futures.add(future);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println("🎉 모든 이메일 전송 완료");
    }
}