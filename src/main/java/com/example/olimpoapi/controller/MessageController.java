package com.example.olimpoapi.controller;

import com.example.olimpoapi.model.redis.Message;
import com.example.olimpoapi.service.MessageService;
import com.example.olimpoapi.utils.GsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/message")
public class MessageController {
    private final MessageService messageService;
    private final GsonUtils gsonUtils;
    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
        this.gsonUtils = new GsonUtils();
    }
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Message message, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors().get(0).getDefaultMessage());
        }
        Message createdMessage = messageService.sendMessage(message);
        return ResponseEntity.ok().body(gsonUtils.toJson(createdMessage));
    }
    @GetMapping("/get/{chatId}")
    public ResponseEntity<String> getAll(@PathVariable("chatId") String chatId) {
        List<Message> messages = messageService.getAllMessagesOfAChat(chatId);
        return ResponseEntity.ok().body(gsonUtils.toJson(messages));
    }
}
