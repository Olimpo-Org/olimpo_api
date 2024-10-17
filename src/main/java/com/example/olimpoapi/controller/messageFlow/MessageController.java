package com.example.olimpoapi.controller.messageFlow;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.mongo.Message;
import com.example.olimpoapi.service.messageFlow.MessageService;
import com.example.olimpoapi.utils.GsonUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Criar nova mensagem", description = "Endpoint cria uma nova a partir de um objeto JSON")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mensagem criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping("/create")
    public ResponseEntity<String> create(
            @Parameter(description = "Mensagem a ser criada")
            @RequestBody Message message, BindingResult result
    ) {
        if (result.hasErrors()) {
            ExceptionThrower.throwBadRequestException(result.getAllErrors().get(0).getDefaultMessage());
        }
        Message createdMessage = messageService.sendMessage(message);
        return ResponseEntity.ok().body(gsonUtils.toJson(createdMessage));
    }

    @Operation(summary = "Listar todas as mensagens de um chat", description = "Endpoint lista todas as mensagens de um chat")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorno de uma lista de mensagens"),
            @ApiResponse(responseCode = "404", description = "Mensagens não encontradas")
    })
    @GetMapping("/get/{chatId}")
    public ResponseEntity<String> getAll(
            @Parameter(description = "Id do chat")
            @PathVariable("chatId") String chatId
    ) {
        List<Message> messages = messageService.getAllMessagesOfAChat(chatId);
        return ResponseEntity.ok().body(gsonUtils.toJson(messages));
    }

    @Operation(summary = "Listar todas as mensagens de um usuário", description = "Endpoint lista todas as mensagens de um usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorno de uma lista de mensagens"),
            @ApiResponse(responseCode = "404", description = "Mensagens não encontradas")
    })
    @DeleteMapping("/delete/{messageId}")
    public ResponseEntity<String> delete(
            @Parameter(description = "Id da mensagem")
            @PathVariable("messageId") String messageId
    ) {
        Message deletedMessage = messageService.deleteMessage(messageId);
        return ResponseEntity.ok().body(gsonUtils.toJson(deletedMessage));
    }
}
