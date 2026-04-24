package com.example.todo_java.domain.todo;

import com.example.todo_java.domain.todo.dto.TodoRequest;
import com.example.todo_java.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
@Getter
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String title;

    private String content;

    @Column(nullable = false)
    private Boolean done = false;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    public Todo(TodoRequest request, User user) {
        this.user = user;
        this.title = request.getTitle();
        this.content = request.getContent();
        this.done = false;
    }

    public void update(String title, String content, Boolean done) {
        this.title = title;
        this.content = content;
        this.done = done;
        this.updatedAt = LocalDateTime.now();
    }
}