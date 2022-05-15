package com.service.user.controller;

import com.service.user.entity.User;
import com.service.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user-service/user")
public class UserController {

    private final UserService userService;

    @GetMapping("{id}")
    public User findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @PostMapping
    public User save(@Valid @RequestBody User user) {
        return userService.save(user);
    }
}
