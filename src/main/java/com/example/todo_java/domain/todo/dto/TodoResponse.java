package com.example.todo_java.domain.todo.dto;

import com.example.todo_java.domain.todo.Todo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoResponse {
    private Long id;
    private String userEmail;
    private String title;
    private String content;
    private Boolean done;
    private LocalDateTime createdAt;

    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.userEmail = todo.getUser().getEmail();
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.done = todo.getDone();
        this.createdAt = LocalDateTime.now();
    }
}