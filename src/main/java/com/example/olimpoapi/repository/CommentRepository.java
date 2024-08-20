package com.example.olimpoapi.repository;

import com.example.olimpoapi.model.mongo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, String> {
}
