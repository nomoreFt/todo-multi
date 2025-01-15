package com.nomoreft.todoapp;

import com.nomoreft.todoapp.todo.domain.Todo;
import com.nomoreft.todoapp.todo.domain.TodoIdGenerator;
import com.nomoreft.todoapp.todo.domain.TodoRepository;
import com.nomoreft.todoapp.todo.domain.TodoText;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@ConditionalOnProperty(name = "todoapp.data.initialize", havingValue = "true")
class TodosDataInitializer implements InitializingBean, ApplicationRunner, CommandLineRunner {

    private final TodoIdGenerator todoIdGenerator;
    private final TodoRepository todoRepository;

    public TodosDataInitializer(TodoIdGenerator todoIdGenerator, TodoRepository todoRepository) {
        this.todoIdGenerator = Objects.requireNonNull(todoIdGenerator);
        this.todoRepository = Objects.requireNonNull(todoRepository);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 1. InitializingBean
        todoRepository.save(Todo.create(TodoText.of("Task one"), todoIdGenerator));
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 2. ApplicationRunner
        todoRepository.save(Todo.create(TodoText.of("Task two"), todoIdGenerator));
    }

    @Override
    public void run(String... args) throws Exception {
        // 3. CommandLineRunner
        todoRepository.save(Todo.create(TodoText.of("Task three"), todoIdGenerator));
    }

}
