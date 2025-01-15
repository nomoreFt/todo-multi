package com.nomoreft.todoapp;

import com.nomoreft.todoapp.todo.application.usecase._3RegisterTodo;
import com.nomoreft.todoapp.todo.domain.TodoText;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/guest/todos")
public class TodoRestController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final _3RegisterTodo registerTodo;

    public TodoRestController(_3RegisterTodo registerTodo) {
        this.registerTodo = registerTodo;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid WriteTodoRequest command) {
        log.debug("request command: {}", command);
        registerTodo.register(TodoText.of(command.text()));
    }


    record WriteTodoRequest(@NotBlank @Size(min = 4, max = 140) String text, boolean completed) {

    }

}
