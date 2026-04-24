package com.example.todo_java.domain.todo;

import com.example.todo_java.domain.todo.dto.TodoRequest;
import com.example.todo_java.domain.todo.dto.TodoResponse;
import com.example.todo_java.domain.user.User;
import com.example.todo_java.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    // 전체 조회
    public List<TodoResponse> findAll() {
        return todoRepository.findAll()
                .stream()
                .map(TodoResponse::new)
                .toList();
    }

    // 단건 조회
    public TodoResponse findById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        return new TodoResponse(todo);
    }

    // 생성
    @Transactional
    public TodoResponse save(TodoRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Todo todo = new Todo(request, user);
        return new TodoResponse(todoRepository.save(todo));
    }

    // 수정
    @Transactional
    public TodoResponse update(Long id, TodoRequest request) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.update(request.getTitle(), request.getContent(), request.getDone());
        return new TodoResponse(todoRepository.save(todo));
    }

    // 삭제
    @Transactional
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}