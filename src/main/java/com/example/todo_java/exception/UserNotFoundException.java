package com.example.todo_java.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User를 찾을 수 없습니다");
    }

    public UserNotFoundException(Long id) {
        super("User를 찾을 수 없습니다. id: " + id);
    }
}