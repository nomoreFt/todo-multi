package com.nomoreft.todoapp.todo.application.usecase;

import com.nomoreft.todoapp.shared.identifier.UserId;
import com.nomoreft.todoapp.todo.domain.Todo;
import com.nomoreft.todoapp.todo.domain.TodoState;

import java.util.List;

/**
 * 2. 사용자는 완료 여부로 할일 목록을 필터링할 수 있습니다.
 */
public interface _2FilterTodosByState {
    List<Todo> filterByState(UserId owner, TodoState state);
}
