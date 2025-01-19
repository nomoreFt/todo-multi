package com.nomoreft.todoapp.shared.event;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class ApplicationEvent<T> {
    private final UUID id; // 이벤트 ID (추적 가능)
    private final LocalDateTime timestamp; // 이벤트 발생 시간 (UTC)
    private final T payload; // 이벤트 데이터

    protected ApplicationEvent(T payload) {
        this.id = UUID.randomUUID(); // 고유 ID 생성
        this.timestamp = LocalDateTime.now(); // UTC 기준 시간 저장
        this.payload = payload;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public T getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "ApplicationEvent{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", payload=" + payload +
                '}';
    }
}