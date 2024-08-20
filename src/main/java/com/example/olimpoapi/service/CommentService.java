package com.example.olimpoapi.service;

import com.example.olimpoapi.repository.CommentRepository;

public class CommentService {
    private final CommentRepository commentRepository;
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
}
