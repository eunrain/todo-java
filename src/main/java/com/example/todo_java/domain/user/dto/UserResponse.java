package com.example.todo_java.domain.user.dto;

import com.example.todo_java.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponse {

    private Long id;
    private String email;
    private LocalDateTime createdAt;

    public UserResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
    }
}