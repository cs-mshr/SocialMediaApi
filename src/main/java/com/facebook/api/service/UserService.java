package com.facebook.api.service;

import com.facebook.api.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {

    User addUser(User user);

    User findUser(UUID id);

    List<User> findAllUser();

    void deleteUser(UUID id);

}
