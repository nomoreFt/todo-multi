package com.nomoreft.todoapp.shared.event;

public interface EventPublisher {
    <T extends ApplicationEvent<?>> void publishEvent(T event);
}