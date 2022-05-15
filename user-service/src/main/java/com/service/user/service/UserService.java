package com.service.user.service;

import com.service.user.entity.User;
import com.service.user.exception.NoSuchElementFoundException;
import com.service.user.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public User findById(String id) {
        return userRepo.findById(id).orElseThrow(() -> new NoSuchElementFoundException(id));
    }

    public User save(User user) {
        return userRepo.save(user);
    }
}
