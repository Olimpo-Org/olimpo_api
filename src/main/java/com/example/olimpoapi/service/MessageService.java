package com.example.olimpoapi.service;

import com.example.olimpoapi.model.redis.Message;
import com.example.olimpoapi.repository.redis.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    private Message sendMessage(Message message) {
        return messageRepository.save(message);
    }
}
