package com.nomoreft.todoapp.email.user;

import com.nomoreft.todoapp.user.domain.event.UserCreatedEvent;
import com.nomoreft.todoapp.user.domain.event.UserPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserEventListener {
    private final UserEmailService userEmailService;

    @TransactionalEventListener
    public void handleUserCreated(UserCreatedEvent event) {
        log.info("UserCreatedEvent 수신: userId={}", event.getPayload());
        UserPayload payload = event.getPayload();
        userEmailService.sendWelcomeEmail(payload.email());
    }

}
