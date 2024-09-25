package com.example.olimpoapi.service.feedFlow;

import com.example.olimpoapi.model.mongo.Comment;
import com.example.olimpoapi.repository.feedFlow.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment create(Comment comment) {
        return commentRepository.create(comment);
    }

    public List<Comment> getAllOfPublication(String publicationId) {
        return commentRepository.getAllOfPublication(publicationId);
    }
}
