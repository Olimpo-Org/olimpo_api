package com.example.olimpoapi.controller.messageFlow;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.mongo.Chat;
import com.example.olimpoapi.service.messageFlow.ChatService;
import com.example.olimpoapi.utils.GsonUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
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

    @Operation(summary = "Criar novo Chat", description = "Endpoint cria uma nova a partir de um objeto JSON")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chat criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping("/create")
    public ResponseEntity<String> create(
            @Parameter(description = "Chat a ser criado")
            @Valid @RequestBody Chat chat, BindingResult result) {
        System.out.println(chat.toString());
        if (result.hasErrors()) {
            ExceptionThrower.throwBadRequestException(result.getAllErrors().get(0).getDefaultMessage());
        }
        Chat createdChat = chatService.create(chat);
        return ResponseEntity.ok().body(gsonUtils.toJson(createdChat));
    }

    @Operation(summary = "Listar todos os Chats", description = "Endpoint lista todos os chats")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chats retornados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Chats não encontrados")
    })
    @GetMapping("/get")
    public ResponseEntity<String> getAll() {
        List<Chat> chats = chatService.getAll();
        return ResponseEntity.ok().body(gsonUtils.toJson(chats));
    }

    @Operation(summary = "Listar todos os Chats de uma comunidade", description = "Endpoint lista todos os chats de uma comunidade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chats retornados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Chats não encontrados")
    })
    @GetMapping("/getByCommunity/{communityId}")
    public ResponseEntity<String> getAllOfCommunity(
            @Parameter(description = "ID da comunidade")
            @PathVariable("communityId") String communityId
    ) {
        List<Chat> chats = chatService.getAllByCommunityId(communityId);
        if (chats.isEmpty()) {
            ExceptionThrower.throwNotFoundException("Chats not found");
        } else if (communityId == null) {
            ExceptionThrower.throwBadRequestException("Community id must be not null");
        }
        return ResponseEntity.ok().body(gsonUtils.toJson(chats));
    }

    @Operation(summary = "Listar todos os Chats de um usuário", description = "Endpoint lista todos os chats de um usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chats retornados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Chats não encontrados")
    })
    @GetMapping("/get/{communityId}/{userId}")
    public ResponseEntity<String> getAllOfCommunityByUser(
            @Parameter(description = "ID da comunidade")
            @PathVariable("communityId") String communityId,
            @Parameter(description = "ID do usuário")
            @PathVariable("userId") String userId
    ) {
        List<Chat> chats = chatService.getAllByUserId(userId, communityId);
        if (chats.isEmpty()) {
            ExceptionThrower.throwNotFoundException("Chats not found fot this user");
        } else if (communityId == null) {
            ExceptionThrower.throwBadRequestException("Community id must be not null");
        }
        return ResponseEntity.ok().body(gsonUtils.toJson(chats));
    }

    @Operation(summary = "Adicionar um usuário a um chat", description = "Endpoint adiciona um usuário a um chat")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário adicionado ao chat com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário ou chat não encontrado")
    })
    @PutMapping("/add/{chatId}/{userId}")
    public ResponseEntity<String> addUserToChat(
            @Parameter(description = "ID do chat")
            @PathVariable("chatId") String chatId,
            @Parameter(description = "ID do usuário")
            @PathVariable("userId") String userId
    ) {
        Chat chat = chatService.addUserToChat(chatId, userId);
        return ResponseEntity.ok().body(gsonUtils.toJson(chat));
    }

    @Operation(summary = "Listar um Chat pelo ID", description = "Endpoint lista um chat pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chat retornado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Chat não encontrado")
    })
    @GetMapping("/get/{chatId}")
    public ResponseEntity<String> getChat(
            @Parameter(description = "ID do chat")
            @PathVariable("chatId") String chatId) {
        Chat chat = chatService.getChatById(chatId);
        if (chat == null) {
            ExceptionThrower.throwNotFoundException("Chat not found");
        }
        return ResponseEntity.ok().body(gsonUtils.toJson(chat));
    }
}
