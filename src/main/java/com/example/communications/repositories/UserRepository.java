package com.example.communications.repositories;

import com.example.communications.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u where u.userName=?1")
    public User getUserByUserName(String name);
}
