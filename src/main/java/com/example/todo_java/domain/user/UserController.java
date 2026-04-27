package com.example.todo_java.domain.user;

import com.example.todo_java.domain.user.dto.UserRequest;
import com.example.todo_java.domain.user.dto.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 전체 조회
    @GetMapping
    public Page<UserResponse> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return userService.findAll(page, size);
    }

    // 단건 조회
    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    // 생성
    @PostMapping
    public UserResponse save(@RequestBody @Valid UserRequest request) {
        return userService.save(request);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}