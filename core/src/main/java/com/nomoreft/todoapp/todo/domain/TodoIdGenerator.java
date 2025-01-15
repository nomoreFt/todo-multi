package com.nomoreft.todoapp.todo.domain;

import com.nomoreft.todoapp.shared.identifier.TodoId;

public interface TodoIdGenerator {

    TodoId generateId();

}

