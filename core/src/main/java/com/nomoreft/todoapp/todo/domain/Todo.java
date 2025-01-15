package com.nomoreft.todoapp.todo.domain;

import com.nomoreft.todoapp.shared.domain.DomainEntity;
import com.nomoreft.todoapp.shared.identifier.TodoId;
import com.nomoreft.todoapp.shared.identifier.UserId;
import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Entity(name = "todos")
@Table(name = "todo_todos")
public class Todo extends DomainEntity<Todo, TodoId> implements Serializable {

    @EmbeddedId
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private TodoId id;

    @Embedded
    private TodoText text;

    @Enumerated(EnumType.STRING)
    private TodoState state = TodoState.ACTIVE;

    @Column(name = "user_id")
    private UserId owner;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    public Todo(TodoId id, TodoText text, LocalDateTime createdDate){
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.text = Objects.requireNonNull(text, "text must not be null");
        this.createdDate = createdDate;
        this.lastModifiedDate = createdDate;
    }

    public Todo(TodoId id, TodoText text, UserId owner, LocalDateTime createdDate){
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.text = Objects.requireNonNull(text, "text must not be null");
        this.owner = Objects.requireNonNull(owner, "owner must not be null");
        this.createdDate = createdDate;
        this.lastModifiedDate = createdDate;
    }

    @SuppressWarnings("unused")
    protected Todo() {}


    public static Todo create(TodoText text, TodoIdGenerator idGenerator) {
        return new Todo(idGenerator.generateId(), text, LocalDateTime.now());
    }

    public static Todo create(TodoText text, UserId owner, TodoIdGenerator idGenerator) {
        return new Todo(idGenerator.generateId(), text, owner, LocalDateTime.now());
    }


    public boolean isCompleted() {
        return state == TodoState.COMPLETED;
    }

    //edit
    public Todo edit(TodoText todoText, boolean completed){
        this.text = Objects.requireNonNull(todoText, "text must not be null");
        this.state = completed ? TodoState.COMPLETED : TodoState.ACTIVE;
        this.lastModifiedDate = LocalDateTime.now();
        return this;
    }

    public Todo edit(TodoText todoText, UserId owner, boolean completed){
        if(Objects.equals(owner, this.owner)) edit(todoText, completed);
        return this;
    }

    @Override
    public TodoId getId() {
        return id;
    }

    public TodoText getText() {
        return text;
    }

    public TodoState getState() {
        return state;
    }

    public UserId getOwner() {
        return owner;
    }
}