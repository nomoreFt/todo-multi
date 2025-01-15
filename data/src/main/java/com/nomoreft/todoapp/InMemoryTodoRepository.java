package com.nomoreft.todoapp;


import com.nomoreft.todoapp.shared.identifier.TodoId;
import com.nomoreft.todoapp.shared.identifier.UserId;
import com.nomoreft.todoapp.todo.domain.Todo;
import com.nomoreft.todoapp.todo.domain.TodoRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.nomoreft.todoapp.foundation.constant.ProfileConstants.*;

@Profile(PROFILE_DEVELOPMENT)
@Repository
class InMemoryTodoRepository implements TodoRepository {

    private final List<Todo> todos = new CopyOnWriteArrayList<>();

    @Override
    public List<Todo> findAll() {
        return Collections.unmodifiableList(todos);
    }

    @Override
    public List<Todo> findByOwner(UserId owner) {
        var result = todos.stream().filter(todo -> Objects.equals(owner, todo.getOwner())).toList();
        return Collections.unmodifiableList(result);
    }

    @Override
    public Optional<Todo> findById(TodoId id) {
        return todos.stream().filter(todo -> Objects.equals(id, todo.getId())).findFirst();
    }

    @Override
    public Todo save(Todo todo) {
        if (!todos.contains(todo)) {
            todos.add(todo);
        }
        return todo;
    }

    @Override
    public void delete(Todo todo) {
        todos.remove(todo);
    }

}
