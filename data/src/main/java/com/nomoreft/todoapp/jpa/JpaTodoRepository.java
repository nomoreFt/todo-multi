package com.nomoreft.todoapp.jpa;


import com.nomoreft.todoapp.shared.identifier.TodoId;
import com.nomoreft.todoapp.todo.domain.Todo;
import com.nomoreft.todoapp.todo.domain.TodoRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import static com.nomoreft.todoapp.foundation.constant.ProfileConstants.*;

@Profile(PROFILE_PRODUCTION)
interface JpaTodoRepository extends TodoRepository, JpaRepository<Todo, TodoId> {

}
