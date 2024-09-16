package com.example.olimpoapi.repository.mongo;

import com.example.olimpoapi.model.mongo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {

    List<Comment> findAllByPublicationId(String publicationId);
}
