package com.example.olimpoapi.service;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.mongo.Chat;
import com.example.olimpoapi.repository.mongo.ChatRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ChatService {
    private final ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public Chat create(Chat chat) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        Date currentDate = Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());

        chat.setCreatedAt(currentDate);
        return chatRepository.save(chat);
    }
    public List<Chat> getAll() {
        List<Chat> chats = chatRepository.findAll();
        if (chats.isEmpty()) {
            ExceptionThrower.throwNotFoundException("Chats not found");
        }
        return chats;
    }
    public List<Chat> getAllByCommunityId(String communityId) {
        //Verificar se o comunidade existe

        List<Chat> chats = chatRepository.findAllByCommunityId(communityId);
        if (chats.isEmpty()) {
            ExceptionThrower.throwNotFoundException("Chats not found for this community");
        }
        return chats;
    }
    public List<Chat> getAllByUserId(String userId, String communityId) {
        List<Chat> allChats = getAllByCommunityId(communityId);
        List<Chat> filteredChats =
                allChats.stream().filter(chat -> chat.getUsersIds().contains(userId)).toList();

        if (filteredChats.isEmpty()) {
            ExceptionThrower.throwNotFoundException("Chats not found for this");
        }
        return filteredChats;
    }
    public Chat addUserToChat(String chatId, String userId) {
        Optional<Chat> chat = chatRepository.findById(chatId);
        //Verificar se o usuário existe TODO
        if (chat.isEmpty()) {
            ExceptionThrower.throwBadRequestException("Chat not found");
        }
        Chat c = chat.get();
        if (c.getUsersIds().contains(userId)) {
            ExceptionThrower.throwBadRequestException("User already in chat");
        }
        List<String> usersIds = c.getUsersIds();
        usersIds.add(userId);
        c.setUsersIds(usersIds);
        return chatRepository.save(c);
    }
    public Chat getChatById(String chatId) {
        Optional<Chat> chat = chatRepository.findById(chatId);
        if (chat.isEmpty()) {
            ExceptionThrower.throwBadRequestException("Chat not found");
        }
        return chat.get();
    }
}
