package com.example.olimpoapi.service;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.redis.Message;
import com.example.olimpoapi.repository.redis.MessageRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getAllMessagesOfAChat(String chatId) {
        List<Message> messages = messageRepository.findAllByChatIdOrderBySendedAtAsc(chatId);
        if (messages.isEmpty()) {
            ExceptionThrower.throwNotFoundException("Messages not found");
        }
        return messages;
    }

    public Message sendMessage(Message message) {
        try {
            return messageRepository.save(message);
        } catch (Exception e) {
            ExceptionThrower.throwBadRequestException("Message not sent");
        }
        return null;
    }
}
