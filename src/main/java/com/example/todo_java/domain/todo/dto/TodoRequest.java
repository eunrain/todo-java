package com.example.todo_java.domain.todo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoRequest {
    @NotBlank(message = "제목은 필수입니다")
    private String title;

    private String content;

    private Boolean done;

    @NotNull(message = "유저 ID는 필수입니다")
    private Long userId;
}