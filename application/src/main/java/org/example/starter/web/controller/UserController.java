package org.example.starter.web.controller;

import lombok.RequiredArgsConstructor;
import org.example.starter.service.UserService;
import org.example.starter.web.controller.model.RequestUserDto;
import org.example.starter.web.controller.model.ResponseUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseUserDto> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @PostMapping
    public ResponseEntity<ResponseUserDto> createUser(@RequestBody RequestUserDto dto) {
        return ResponseEntity.ok(userService.createUser(dto));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User: " + userId + " deleted");
    }
}
