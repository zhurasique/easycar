package com.service.auth.controller;

import com.service.auth.domain.User;
import com.service.auth.service.UserService;
import com.service.auth.vo.Exists;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	@GetMapping(value = "/{id}")
	public Optional<User> findById(@PathVariable String id) {
		return userService.findById(id);
	}

	@GetMapping(value = "/exists/{id}")
	public Exists isUserExists(@PathVariable String id) {
		return userService.isUserExists(id);
	}

	@GetMapping(value = "/current")
	public Principal getUser(Principal principal) {
		return principal;
	}

	@PreAuthorize("#oauth2.hasScope('server')")
	@PostMapping
	public void createUser(@Valid @RequestBody User user) {
		userService.createUser(user);
	}
}
