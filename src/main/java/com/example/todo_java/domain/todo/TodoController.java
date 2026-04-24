package com.example.todo_java.domain.todo;

import com.example.todo_java.domain.todo.dto.TodoRequest;
import com.example.todo_java.domain.todo.dto.TodoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    // 전체 조회
    @GetMapping
    public List<TodoResponse> findAll() {
        return todoService.findAll();
    }

    // 단건 조회
    @GetMapping("/{id}")
    public TodoResponse findById(@PathVariable Long id) {
        return todoService.findById(id);
    }

    // 생성
    @PostMapping
    public TodoResponse save(@RequestBody @Valid TodoRequest request) {
        return todoService.save(request);
    }

    // 수정
    @PutMapping("/{id}")
    public TodoResponse update(@PathVariable Long id, @RequestBody @Valid TodoRequest request) {
        return todoService.update(id, request);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        todoService.delete(id);
    }
}
