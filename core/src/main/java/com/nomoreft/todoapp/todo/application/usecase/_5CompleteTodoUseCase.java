package com.nomoreft.todoapp.todo.application.usecase;

import com.nomoreft.todoapp.shared.identifier.UserId;

/**
 * 5. 등록된 할일을 완료할 수 있습니다.
 */
public interface _5CompleteTodoUseCase {
    void complete(Long todoId, UserId owner);
}
