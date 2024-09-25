package com.example.olimpoapi.controller.feedFlow;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.mongo.Comment;
import com.example.olimpoapi.service.feedFlow.CommentService;
import com.example.olimpoapi.utils.GsonUtils;
import com.google.gson.Gson;
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
    @GetMapping("/get/publication/{publicationId}")
    public ResponseEntity<String> getAllOfPublication(
            @PathVariable("publicationId") String publicationId
    ) {
        List<Comment> comments = commentService.getAllOfPublication(publicationId);
        return ResponseEntity.ok().body(gsonUtils.toJson(comments));
    }
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Comment comment, BindingResult result) {
        if (result.hasErrors()) {
            ExceptionThrower.throwBadRequestException(result.getAllErrors().get(0).getDefaultMessage());
        }
        Comment createdComment = commentService.create(comment);
        return ResponseEntity.ok().body(gsonUtils.toJson(createdComment));
    }

}
