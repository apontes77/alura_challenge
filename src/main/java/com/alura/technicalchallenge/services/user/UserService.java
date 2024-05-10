package com.alura.technicalchallenge.services.user;

import com.alura.technicalchallenge.domain.UserEntity;
import com.alura.technicalchallenge.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserEntity getUser(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
