package com.facebook.api.service.Impl;

import com.facebook.api.model.User;
import com.facebook.api.repository.UserRepo;
import com.facebook.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepo repo;

    @Override
    public User addUser(User user) {
        user.setId(UUID.randomUUID());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return repo.save(user);
    }

    @Override
    public User findUser(UUID id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<User> findAllUser() {
        return repo.findAll();
    }

    @Override
    public void deleteUser(UUID id) {
        repo.deleteById(id);
    }
}
