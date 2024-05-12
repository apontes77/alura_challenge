package com.alura.technicalchallenge.services.user;

import com.alura.technicalchallenge.domain.UserEntity;
import com.alura.technicalchallenge.domain.enums.Role;
import com.alura.technicalchallenge.domain.exceptions.UserNotFoundException;
import com.alura.technicalchallenge.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserEntity getUser(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with username "+username+" was not found"));
    }

    public Optional<UserEntity> searchForEmailOrUsername(String email, String username) {
        return repository.findByEmailOrUsername(email, username);
    }

    public UserEntity saveUser(UserEntity userEntity) {
        return repository.save(userEntity);
    }

    public Role obtainUserRole(String username) {
        UserEntity user = this.getUser(username);
        return user.getRole();
    }
}
