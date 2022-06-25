package com.example.communications.Service;

import com.example.communications.models.Chat;
import com.example.communications.repositories.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
    private final ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public void create(Chat chat) {
        chatRepository.save(chat);
    }

    public List<Chat> getChats() {
        return chatRepository.findAll();
    }
}
