package com.example.olimpoapi.controller;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.mongo.Chat;
import com.example.olimpoapi.service.ChatService;
import com.example.olimpoapi.utils.GsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Chat chat, BindingResult result) {
        System.out.println(chat.toString());
        if (result.hasErrors()) {
            ExceptionThrower.throwBadRequestException(result.getAllErrors().get(0).getDefaultMessage());
        }
        Chat createdChat = chatService.create(chat);
        return ResponseEntity.ok().body(gsonUtils.toJson(createdChat));
    }
    @GetMapping("/get")
    public ResponseEntity<String> getAll() {
        List<Chat> chats = chatService.getAll();
        return ResponseEntity.ok().body(gsonUtils.toJson(chats));
    }

    @GetMapping("/get/{communityId}")
    public ResponseEntity<String> getAllOfCommunity(@PathVariable("communityId") String communityId) {
        List<Chat> chats = chatService.getAllByCommunityId(communityId);
        if (chats.isEmpty()) {
            ExceptionThrower.throwNotFoundException("Chats not found");
        } else if (communityId == null) {
            ExceptionThrower.throwBadRequestException("Community id must be not null");
        }
        return ResponseEntity.ok().body(gsonUtils.toJson(chats));
    }

    @GetMapping("/get/{communityId}/{userId}")
    public ResponseEntity<String> getAllOfCommunityByUser(@PathVariable("communityId") String communityId, @PathVariable("userId") String userId) {
        List<Chat> chats = chatService.getAllByUserId(userId, communityId);
        if (chats.isEmpty()) {
            ExceptionThrower.throwNotFoundException("Chats not found fot this user");
        } else if (communityId == null) {
            ExceptionThrower.throwBadRequestException("Community id must be not null");
        }
        return ResponseEntity.ok().body(gsonUtils.toJson(chats));
    }

    @PostMapping("/add/{chatId}/{userId}")
    public ResponseEntity<String> addUserToChat(
            @PathVariable("chatId") String chatId,
            @PathVariable("userId") String userId
    ) {
        Chat chat = chatService.addUserToChat(chatId, userId);
        return ResponseEntity.ok().body(gsonUtils.toJson(chat));
    }
    @PostMapping("get/{chatId}")
    public ResponseEntity<String> getChat(@PathVariable("chatId") String chatId) {
        Chat chat = chatService.getChatById(chatId);
        return ResponseEntity.ok().body(gsonUtils.toJson(chat));
    }
}
