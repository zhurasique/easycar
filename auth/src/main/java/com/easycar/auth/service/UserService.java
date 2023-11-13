package com.easycar.auth.service;

import com.easycar.auth.domain.User;
import com.easycar.auth.exception.UserExistsException;
import com.easycar.auth.repository.UserRepository;
import com.easycar.auth.vo.Exists;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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

	public void createUser(User user) {
		Optional<User> existing = userRepo.findById(user.getUsername());
		existing.ifPresent(it -> {
			throw new UserExistsException(it.getUsername());
		});
		String hash = encoder.encode(user.getPassword());
		user.setPassword(hash);
		user.setRoles(new String[]{"USER"});
		userRepo.save(user);
	}
}
