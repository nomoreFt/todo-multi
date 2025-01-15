package com.nomoreft.todoapp.todo.application.usecase;

import com.nomoreft.todoapp.shared.identifier.UserId;

/**
 * 7. 완료된 할일을 정리할 수 있습니다.
 */
public interface _7ClearCompletedTodos {
    int clearCompleted(UserId owner);
}
