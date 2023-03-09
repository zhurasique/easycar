package com.service.auth.service;

import com.service.auth.domain.User;
import com.service.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	private final UserRepository repository;

	public void create(User user) {
		Optional<User> existing = repository.findById(user.getUsername());
		existing.ifPresent(it -> {
			throw new IllegalArgumentException("user already exists: " + it.getUsername());
		});

		String hash = encoder.encode(user.getPassword());
		user.setPassword(hash);

		repository.save(user);

		log.info("new user has been created: {}", user.getUsername());
	}
}
