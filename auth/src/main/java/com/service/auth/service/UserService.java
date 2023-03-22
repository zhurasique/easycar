package com.service.auth.service;

import com.service.auth.domain.User;
import com.service.auth.exception.NoSuchElementFoundException;
import com.service.auth.exception.UserExistsException;
import com.service.auth.repository.UserRepository;
import com.service.auth.vo.Exists;
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

	public Optional<User> findById(String id) {
		return userRepo.findById(id);
	}

	public Exists isUserExists(String id) {
		Optional<User> user = findById(id);
		Exists exists = new Exists();
		if (user.isPresent()) {
			exists.setExists(true);
			return exists;
		}
		exists.setExists(false);
		return exists;
	}

	public User getUser(Principal principal) {
		return userRepo.findById(principal.getName()).orElseThrow(() -> new NoSuchElementFoundException(principal.getName()));
	}

	public void createUser(User user) {
		Optional<User> existing = userRepo.findById(user.getUsername());
		existing.ifPresent(it -> {
			throw new UserExistsException(it.getUsername());
		});
		String hash = encoder.encode(user.getPassword());
		user.setPassword(hash);
		userRepo.save(user);
	}
}
