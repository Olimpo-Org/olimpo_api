package com.example.olimpoapi.controller.feedFlow;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.mongo.Comment;
import com.example.olimpoapi.service.feedFlow.CommentService;
import com.example.olimpoapi.utils.GsonUtils;
import com.google.gson.Gson;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.validation.Validator;
import java.util.List;

@RestController
@RequestMapping("/v1/comment")
public class CommentController {
    private final CommentService commentService;
    private final GsonUtils gsonUtils;
    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
        this.gsonUtils = new GsonUtils();
    }
    @Operation(summary = "Listar todos os comentários de uma publicação", description = "Endpoint lista todos os comentários de uma publicação")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comentários retornados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Comentários não encontrados")
    })
    @GetMapping("/get/publication/{publicationId}")
    public ResponseEntity<String> getAllOfPublication(
            @Parameter(description = "Id da publicação")
            @PathVariable("publicationId") String publicationId
    ) {
        List<Comment> comments = commentService.getAllOfPublication(publicationId);
        return ResponseEntity.ok().body(gsonUtils.toJson(comments));
    }

    @Operation(summary = "Criar novo Comentário", description = "Endpoint cria uma nova a partir de um objeto JSON")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comentário criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping("/create")
    public ResponseEntity<String> create(
            @Parameter(description = "Comentário a ser criado")
            @RequestBody Comment comment, BindingResult result) {
        if (result.hasErrors()) {
            ExceptionThrower.throwBadRequestException(result.getAllErrors().get(0).getDefaultMessage());
        }
        Comment createdComment = commentService.create(comment);
        return ResponseEntity.ok().body(gsonUtils.toJson(createdComment));
    }

}
