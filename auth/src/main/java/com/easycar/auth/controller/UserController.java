package com.easycar.auth.controller;

import com.easycar.auth.client.AccountServiceClient;
import com.easycar.auth.domain.User;
import com.easycar.auth.service.UserService;
import com.easycar.auth.vo.Exists;
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
	private final AccountServiceClient accountServiceClient;

	@GetMapping(value = "/{id}")
	public Optional<User> findById(@PathVariable String id) {
		accountServiceClient.findById("a");
		return userService.findById(id);
	}

	@PreAuthorize("#oauth2.hasScope('server')")
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
