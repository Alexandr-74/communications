package com.example.communications.repositories;

import com.example.communications.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u where u.userName=?1")
    User getUserByUserName(String name);

    @Query("SELECT min(u.contactsCount) FROM User u")
    int getMinContactsCount();

    @Query("SELECT max(u.contactsCount) FROM User u")
    int getMaxContactsCount();

    @Query("SELECT avg(u.contactsCount) FROM User u")
    int getAvgContactsCount();

    @Query("SELECT  u FROM User u where u.contactsCount=?1")
    List<User> getCountContactsUser(int count);

}
