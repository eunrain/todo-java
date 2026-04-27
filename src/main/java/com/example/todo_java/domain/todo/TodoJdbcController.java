package com.example.todo_java.domain.todo;

import com.example.todo_java.domain.todo.dto.TodoJdbcResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jdbc/todos")
@RequiredArgsConstructor
public class TodoJdbcController {
    private final TodoJdbcRepository todoJdbcRepository;

    // 단건 조회
    @GetMapping("/{id}")
    public TodoJdbcResponse findById(@PathVariable Long id) {
        Todo todo = todoJdbcRepository.findById(id);
        return new TodoJdbcResponse(todo);
    }
}