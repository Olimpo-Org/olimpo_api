package com.example.olimpoapi.controller.messageFlow;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.mongo.Message;
import com.example.olimpoapi.service.messageFlow.MessageService;
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
            ExceptionThrower.throwBadRequestException(result.getAllErrors().get(0).getDefaultMessage());
        }
        Message createdMessage = messageService.sendMessage(message);
        return ResponseEntity.ok().body(gsonUtils.toJson(createdMessage));
    }
    @GetMapping("/get/{chatId}")
    public ResponseEntity<String> getAll(@PathVariable("chatId") String chatId) {
        List<Message> messages = messageService.getAllMessagesOfAChat(chatId);
        return ResponseEntity.ok().body(gsonUtils.toJson(messages));
    }

    @DeleteMapping("/delete/{messageId}")
    public ResponseEntity<String> delete(@PathVariable("messageId") String messageId) {
        Message deletedMessage = messageService.deleteMessage(messageId);
        return ResponseEntity.ok().body(gsonUtils.toJson(deletedMessage));
    }
}
