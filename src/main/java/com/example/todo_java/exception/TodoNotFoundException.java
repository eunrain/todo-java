package com.example.todo_java.exception;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException() {
        super("Todo를 찾을 수 없습니다");
    }

    public TodoNotFoundException(Long id) {
        super("Todo를 찾을 수 없습니다. id: " + id);
    }
}