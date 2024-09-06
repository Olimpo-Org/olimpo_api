package com.example.olimpoapi.repository.mongo;

import com.example.olimpoapi.model.mongo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
