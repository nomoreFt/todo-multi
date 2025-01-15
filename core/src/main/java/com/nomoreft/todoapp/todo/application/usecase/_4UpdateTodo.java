package com.nomoreft.todoapp.todo.application.usecase;

import com.nomoreft.todoapp.shared.identifier.TodoId;
import com.nomoreft.todoapp.shared.identifier.UserId;
import com.nomoreft.todoapp.todo.domain.TodoState;
import com.nomoreft.todoapp.todo.domain.TodoText;

/**
 * 4. 사용자는 등록된 할일을 변경할 수 있습니다.
 */
public interface _4UpdateTodo {
    void update(UserId owner, TodoId todoId, TodoText text, TodoState state);

}
