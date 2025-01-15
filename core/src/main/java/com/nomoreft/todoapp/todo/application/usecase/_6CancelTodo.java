package com.nomoreft.todoapp.todo.application.usecase;

import com.nomoreft.todoapp.shared.identifier.TodoId;
import com.nomoreft.todoapp.shared.identifier.UserId;

/**
 * 6. 등록된 할일을 취소할 수 있습니다.
 */
public interface _6CancelTodo {
    void cancel(TodoId todoId, UserId owner);
}
