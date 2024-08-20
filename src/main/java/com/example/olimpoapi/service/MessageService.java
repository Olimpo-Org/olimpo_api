package com.example.olimpoapi.service;

import com.example.olimpoapi.repository.MessageRepository;

public class MessageService {
    private final MessageRepository messageRepository;
    private MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
}
