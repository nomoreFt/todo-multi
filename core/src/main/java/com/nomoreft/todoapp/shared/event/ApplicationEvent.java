package com.nomoreft.todoapp.shared.event;

public abstract class ApplicationEvent {

    private final long timestamp;

    public ApplicationEvent() {
        this.timestamp = System.currentTimeMillis();
    }

    public long getTimestamp() {
        return timestamp;
    }
}