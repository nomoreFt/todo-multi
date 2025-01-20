package com.nomoreft.todoapp.user.application.service;

import com.nomoreft.todoapp.shared.identifier.UserId;
import com.nomoreft.todoapp.user.domain.UserName;
import com.nomoreft.todoapp.user.domain.event.UserCreatedEvent;
import com.nomoreft.todoapp.user.domain.event.UserEvent;
import com.nomoreft.todoapp.user.domain.event.UserEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DefaultUserService {
    private final UserEventPublisher userEventPublisher;

    @Transactional
    public void createUser(UserId userId, UserName username, String email) {
        // 사용자 생성 로직
        // ...
        // 사용자 생성 후 이벤트 발행
        userEventPublisher.publishEvent(new UserCreatedEvent(userId, username, email));
    }
}
