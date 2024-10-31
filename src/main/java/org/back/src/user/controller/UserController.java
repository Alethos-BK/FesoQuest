package org.back.src.user.controller;

import org.back.src.user.dto.UserRequestDto;
import org.back.src.user.dto.UserResponseDto;
import org.back.src.shared.exception.CustomException;
import org.back.src.user.service.UserService;
import org.back.src.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable("id") int id) throws CustomException {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<User> create(@RequestBody UserRequestDto userRequestDto) throws CustomException {
        return new ResponseEntity<>(userService.create(userRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable("id") int id,
                                       @RequestBody UserRequestDto updatedUser) throws CustomException {
        return ResponseEntity.ok(userService.update(id, updatedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws CustomException {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
