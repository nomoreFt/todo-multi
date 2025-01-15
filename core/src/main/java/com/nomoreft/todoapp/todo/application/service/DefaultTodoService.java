package com.nomoreft.todoapp.todo.application.service;

import com.nomoreft.todoapp.shared.identifier.UserId;
import com.nomoreft.todoapp.todo.application.usecase._3RegisterTodo;
import com.nomoreft.todoapp.todo.domain.Todo;
import com.nomoreft.todoapp.todo.domain.TodoIdGenerator;
import com.nomoreft.todoapp.todo.domain.TodoRepository;
import com.nomoreft.todoapp.todo.domain.TodoText;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultTodoService implements _3RegisterTodo {

    private final TodoIdGenerator todoIdGenerator;
    private final TodoRepository todoRepository;

    public DefaultTodoService(TodoIdGenerator todoIdGenerator, TodoRepository todoRepository) {
        this.todoIdGenerator = todoIdGenerator;
        this.todoRepository = todoRepository;
    }

    @Override
    @Transactional
    public Todo register(TodoText text, UserId owner) {
        return todoRepository.save(Todo.create(text, owner, todoIdGenerator));
    }

    @Override
    @Transactional
    public Todo register(TodoText text) {
        return todoRepository.save(Todo.create(text, todoIdGenerator));
    }
}
