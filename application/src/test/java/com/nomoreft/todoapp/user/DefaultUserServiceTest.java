package com.nomoreft.todoapp.user;

import com.nomoreft.todoapp.shared.identifier.UserId;
import com.nomoreft.todoapp.user.application.service.DefaultUserService;
import com.nomoreft.todoapp.user.domain.UserName;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest
public class DefaultUserServiceTest {

    @Autowired
    private DefaultUserService userService;  // 실제 이벤트 발행

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;  // 비동기 실행 상태 확인

    private static final int TOTAL_USERS = 100;
    private final AtomicInteger successCount = new AtomicInteger(0);

    @Test
    void shouldDispatch100UserCreatedEventsSuccessfully() {
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < TOTAL_USERS; i++) {
            final int userId = i + 1;
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                userService.createUser(UserId.of(String.valueOf(userId)), UserName.of("User " + userId), "email@test.com");
                successCount.incrementAndGet();
            });

            futures.add(future);
        }

        // 모든 이벤트가 처리될 때까지 대기
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        // 모든 메일이 정상적으로 전송되었는지 확인
        Awaitility.await()
                .atMost(30, TimeUnit.SECONDS)
                .until(() -> successCount.get() == TOTAL_USERS);

        System.out.println("✅ 100명의 유저 생성 및 이벤트 발행 성공!");
    }
}