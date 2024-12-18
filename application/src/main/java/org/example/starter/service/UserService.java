package org.example.starter.service;

import lombok.RequiredArgsConstructor;
import org.example.starter.domain.User;
import org.example.starter.exception.UserNotFoundException;
import org.example.starter.mapper.UserMapper;
import org.example.starter.repository.UserRepository;
import org.example.starter.web.controller.model.RequestUserDto;
import org.example.starter.web.controller.model.ResponseUserDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional(readOnly = true)
    public ResponseUserDto getUser(Long userId) {
        return userMapper.toDTO(getEntity(userId));
    }

    @Transactional
    public ResponseUserDto createUser(RequestUserDto userDto) {
        User user = userMapper.toEntity(userDto);
        return userMapper.toDTO(userRepository.save(user));
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    private User getEntity(Long userId) {
        Optional<User> userEntity = userRepository.findById(userId);
        return userEntity.orElseThrow(() -> new UserNotFoundException(String.valueOf(userId)));
    }
}
