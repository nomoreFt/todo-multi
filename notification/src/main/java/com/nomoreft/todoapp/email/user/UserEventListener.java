package com.nomoreft.todoapp.email.user;

import com.nomoreft.todoapp.user.application.UserCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserEventListener {


    @TransactionalEventListener
    public void handleUserCreated(UserCreatedEvent event) {
        log.info("UserCreatedEvent 수신: userId={}, username={}", event.getUserId(), event.getUsername());
        userNotificationService.sendWelcomeNotification(event.getUserId(), event.getUsername());
    }

}
