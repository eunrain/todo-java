package com.example.todo_java.domain.user;

import com.example.todo_java.domain.user.dto.UserRequest;
import com.example.todo_java.domain.user.dto.UserResponse;
import com.example.todo_java.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // 전체 조회
    public List<UserResponse> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserResponse::new)
                .toList();
    }

    // 단건 조회
    public UserResponse findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return new UserResponse(user);
    }

    // 생성
    public UserResponse save(UserRequest request) {
        User user = new User(request);
        return new UserResponse(userRepository.save(user));
    }

    // 삭제
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}