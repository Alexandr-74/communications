package com.example.communications.Controllers;

import com.example.communications.Service.ChatService;
import com.example.communications.Service.ContactsService;
import com.example.communications.Service.UserService;
import com.example.communications.models.Chat;
import com.example.communications.models.Communication;
import com.example.communications.models.Contacts;
import com.example.communications.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class ChatController {
    private final ChatService chatService;
    private final UserService userService;
    private final ContactsService contactsService;

    public ChatController(ChatService chatService, UserService userService, ContactsService contactsService) {
        this.chatService = chatService;
        this.userService = userService;
        this.contactsService = contactsService;
    }


    @PostMapping("/communication")
    public ResponseEntity<?> create(@RequestBody Communication users) {

        List<User> newUsers = users.getUsers()
                .stream()
                .map(a->{
                    if (userService.getUserByUserName(a.getUserName())!=null) {
                        a = userService.getUserByUserName(a.getUserName());
                    } else {
                        a = userService.createUser(a);
                    }
                    return a;
                })
                .collect(Collectors.toList());


        newUsers.forEach(u->
        {
            newUsers.forEach(c-> {
                if (!Objects.equals(c.getUserName(), u.getUserName())) {
                    Contacts contacts = new Contacts();
                    contacts.setUser(u);
                    contacts.setContact(c);
                    if (contactsService.getContactByAll(contacts)==null)
                        contactsService.createContact(contacts);
                }
            });
        });

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/communications")
    public ResponseEntity<?> getChats() {
        List<User> users = userService.getUsers();

        return users != null && !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


