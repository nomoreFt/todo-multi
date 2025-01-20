package com.nomoreft.todoapp.user.domain.event;

import com.nomoreft.todoapp.shared.event.ApplicationEvent;
import com.nomoreft.todoapp.shared.event.EventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class UserEventPublisher implements EventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    public UserEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public <T extends ApplicationEvent<?>> void publishEvent(T event) {
        applicationEventPublisher.publishEvent(event);
    }
}