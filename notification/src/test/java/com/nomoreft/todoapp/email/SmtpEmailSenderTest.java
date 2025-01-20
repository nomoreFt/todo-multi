package com.nomoreft.todoapp.email;

import com.nomoreft.todoapp.email.config.EmailConfig;
import com.nomoreft.todoapp.user.application.service.DefaultUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
@Import({SmtpEmailSender.class, EmailConfig.class})
class SmtpEmailSenderTest {

    @Autowired
    private DefaultUserService userService;

    private static final int TOTAL_EMAILS = 100;

    @Test
    void sendEmailsAsync_100Times() throws InterruptedException {
        String from = "your-email@gmail.com";
        String to = "receiver-email@example.com";
        String subject = "📧 성능 테스트 - 비동기 이메일 전송";
        String body = "<h3>이메일 전송 테스트</h3><p>비동기 로직이 정상 동작하는지 확인하세요.</p>";

        ExecutorService executor = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(TOTAL_EMAILS);

        for (int i = 0; i < TOTAL_EMAILS; i++) {
            final int emailNumber = i + 1;
            executor.execute(() -> {
                try {
                    emailSender.sendEmail(from, to, subject + " #" + emailNumber, body);
                    System.out.println("✅ 이메일 전송 성공: " + emailNumber);
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await(); // 모든 이메일 전송이 끝날 때까지 대기
        System.out.println("모든 이메일 전송 완료");
    }
}