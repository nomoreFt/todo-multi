package com.nomoreft.todoapp.todo.application.usecase;

import com.nomoreft.todoapp.shared.identifier.UserId;
import com.nomoreft.todoapp.todo.domain.Todo;

import java.util.List;

/**
 * 1. 사용자의 할일 목록을 조회할 수 있습니다.
 */
public interface _1RetrieveTodos {
    List<Todo> retrieveAll(UserId owner);
}
