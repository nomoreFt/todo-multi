package com.nomoreft.todoapp.todo.application.usecase;

import com.nomoreft.todoapp.shared.identifier.UserId;
import com.nomoreft.todoapp.todo.domain.Todo;
import com.nomoreft.todoapp.todo.domain.TodoText;

/**
 * 3. 사용자는 새로운 할일을 등록할 수 있습니다.
 */
public interface _3RegisterTodo {
    Todo register(TodoText text, UserId owner);

    Todo register(TodoText text);
}
