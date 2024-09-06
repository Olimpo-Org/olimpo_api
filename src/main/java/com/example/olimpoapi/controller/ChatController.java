package com.example.olimpoapi.controller;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.mongo.Chat;
import com.example.olimpoapi.service.ChatService;
import com.example.olimpoapi.utils.GsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/chat")
public class ChatController{
    private final ChatService chatService;
    private final GsonUtils gsonUtils;
    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
        this.gsonUtils = new GsonUtils();
    }
    @RequestMapping("/create")
    public ResponseEntity<String> create(@RequestBody Chat chat, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors().get(0).getDefaultMessage());
        }
        Chat createdChat = chatService.create(chat);
        return ResponseEntity.ok().body(gsonUtils.toJson(createdChat));
    }
    @RequestMapping("/get")
    public ResponseEntity<String> getAll() {
        List<Chat> chats = chatService.getAll();
        return ResponseEntity.ok().body(gsonUtils.toJson(chats));
    }

    @RequestMapping("/get/{communityId}")
    public ResponseEntity<String> getAllOfCommunity(@PathVariable("communityId") String communityId) {
        List<Chat> chats = chatService.getAllByCommunityId(communityId);
        if (chats.isEmpty()) {
            ExceptionThrower.throwNotFoundException("Chats not found");
        } else if (communityId == null) {
            ExceptionThrower.throwBadRequestException("Community id must be not null");
        }
        return ResponseEntity.ok().body(gsonUtils.toJson(chats));
    }

    @RequestMapping("/get/{communityId}/{userId}")
    public ResponseEntity<String> getAllOfCommunityByUser(@PathVariable("communityId") String communityId, @PathVariable("userId") String userId) {
        List<Chat> chats = chatService.getAllByUserId(userId, communityId);
        if (chats.isEmpty()) {
            ExceptionThrower.throwNotFoundException("Chats not found fot this user");
        } else if (communityId == null) {
            ExceptionThrower.throwBadRequestException("Community id must be not null");
        }
        return ResponseEntity.ok().body(gsonUtils.toJson(chats));
    }

    @RequestMapping("/add/{chatId}/{userId}")
    public ResponseEntity<String> addUserToChat(
            @PathVariable("chatId") String chatId,
            @PathVariable("userId") String userId
    ) {
        Chat chat = chatService.addUserToChat(chatId, userId);
        return ResponseEntity.ok().body(gsonUtils.toJson(chat));
    }
}
