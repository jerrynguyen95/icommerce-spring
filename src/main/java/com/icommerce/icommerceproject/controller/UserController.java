package com.icommerce.icommerceproject.controller;

import com.icommerce.icommerceproject.dto.response.UserDto;
import com.icommerce.icommerceproject.dto.response.mapper.UserMapper;
import com.icommerce.icommerceproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user/{user-id}")
    public ResponseEntity<UserDto> loadCard(@PathVariable(name = "user-id") Integer userId) {
        return ResponseEntity.ok(userMapper.toDto(userRepository.getReferenceById(userId)));
    }
}
