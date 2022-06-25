package com.example.communications.repositories;

import com.example.communications.models.Contacts;
import com.example.communications.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, Long> {
    @Query("SELECT c FROM Contacts c WHERE c.contact=?1 and c.user=?2")
    Contacts getContactByAll(User contact, User user);
    @Query("SELECT COUNT(c) FROM Contacts c WHERE c.user=?1")
    int getCountOfComs(User user);
}
