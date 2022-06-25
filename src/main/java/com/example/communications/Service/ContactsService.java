package com.example.communications.Service;

import com.example.communications.models.Contacts;
import com.example.communications.models.User;
import com.example.communications.repositories.ContactsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsService {
    private final ContactsRepository contactsRepository;

    public ContactsService(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    public Long createContact(Contacts contacts) {
        return contactsRepository.save(contacts).getId();
    }

    public Contacts getContactByAll(Contacts contact) {
        return contactsRepository.getContactByAll(contact.getContact(), contact.getUser());
    }

    public int getCountOfComs(User user) {
        return contactsRepository.getCountOfComs(user);
    }
}
