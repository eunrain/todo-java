package com.example.todo_java.domain.todo.dto;

import com.example.todo_java.domain.todo.Todo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoJdbcResponse {
    private final String title;
    private final String content;
    private final Boolean done;
    private final LocalDateTime createdAt;
    private final Long id;

    public TodoJdbcResponse(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.done = todo.getDone();
        this.createdAt = todo.getCreatedAt();
    }
}