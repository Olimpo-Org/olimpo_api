package com.example.olimpoapi.service;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.mongo.Comment;
import com.example.olimpoapi.repository.mongo.CommentRepository;
import com.example.olimpoapi.repository.mongo.PublicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PublicationRepository publicationRepository;
    public CommentService(CommentRepository commentRepository, PublicationRepository publicationRepository) {
        this.commentRepository = commentRepository;
        this.publicationRepository = publicationRepository;
    }
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }
    public List<Comment> getAllOfPublication(String publicationId) {
        try {
            if (!publicationRepository.existsById(publicationId)) {
                ExceptionThrower.throwNotFoundException("Publication not found");
            }
            return commentRepository.findAllByPublicationId(publicationId);
        } catch (Exception e) {
            ExceptionThrower.throwNotFoundException("Publication not found");
            return null;
        }
    }
}
