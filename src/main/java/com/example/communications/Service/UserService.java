package com.example.communications.Service;

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


    public int getMinContactsCount() {
        return userRepository.getMinContactsCount();
    }

    public int getMaxContactsCount() {
        return userRepository.getMaxContactsCount();
    }

    public List<User> getMinCountContactsUser() {
        return userRepository.getCountContactsUser(getMinContactsCount());
    }

    public List<User> getMaxContactsUser() {
        return userRepository.getCountContactsUser(getMaxContactsCount());
    }

    public int getAvgContactsCount() {
        return userRepository.getAvgContactsCount();
    }

    public boolean update(User user, Long id) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            userRepository.save(user);
            return true;
        }

        return false;
    }
}
