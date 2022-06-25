package com.example.communications.Service;

import com.example.communications.models.Communication;
import com.example.communications.models.User;
import com.example.communications.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public User getUserByUserName(String name) {
        return userRepository.getUserByUserName(name);
    }

    public void createUsers(List<User> users) {
        userRepository.saveAll(users);
    }
}
