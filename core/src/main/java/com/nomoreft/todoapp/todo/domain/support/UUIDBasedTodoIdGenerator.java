package com.nomoreft.todoapp.todo.domain.support;

import com.nomoreft.todoapp.shared.identifier.TodoId;
import com.nomoreft.todoapp.todo.domain.TodoIdGenerator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class UUIDBasedTodoIdGenerator implements TodoIdGenerator {

    @Override
    public TodoId generateId() {
        return TodoId.of(UUID.randomUUID().toString());
    }

}
