package com.nomoreft.todoapp.todo.domain;

import com.nomoreft.todoapp.shared.identifier.TodoId;
import com.nomoreft.todoapp.shared.identifier.UserId;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    List<Todo> findAll();

    List<Todo> findByOwner(UserId owner);

    Optional<Todo> findById(TodoId id);

    Todo save(Todo todo);

    void delete(Todo todo);
}
