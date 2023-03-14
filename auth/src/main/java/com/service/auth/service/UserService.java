package com.service.auth.service;

import com.service.auth.domain.User;
import com.service.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	private final UserRepository userRepo;

	public User getUser(Principal principal) throws Exception {
		return userRepo.findById(principal.getName()).orElseThrow(Exception::new);
	}

	public void createUser(User user) {
		Optional<User> existing = userRepo.findById(user.getUsername());
		existing.ifPresent(it -> {
			throw new IllegalArgumentException("user already exists: " + it.getUsername());
		});

		String hash = encoder.encode(user.getPassword());
		user.setPassword(hash);

		userRepo.save(user);
	}
}
