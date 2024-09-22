package com.example.olimpoapi.controller;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.mongo.Comment;
import com.example.olimpoapi.service.CommentService;
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
    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping("/get/publication/{publicationId}")
    public ResponseEntity<String> getAllOfPublication(
            @PathVariable("publicationId") String publicationId
    ) {
        List<Comment> comments = commentService.getAllOfPublication(publicationId);
        return ResponseEntity.ok().body(comments.toString());
    }
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Comment comment, BindingResult result) {
        if (result.hasErrors()) {
            ExceptionThrower.throwBadRequestException(result.getAllErrors().get(0).getDefaultMessage());
        }
        Comment createdComment = commentService.create(comment);
        return ResponseEntity.ok().body(createdComment.toString());
    }

}
