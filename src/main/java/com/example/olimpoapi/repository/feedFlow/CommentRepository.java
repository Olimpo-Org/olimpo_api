package com.example.olimpoapi.repository.feedFlow;

import com.example.olimpoapi.model.mongo.Comment;
import com.example.olimpoapi.utils.IdGenerator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository {

    private final MongoTemplate mongoTemplate;
    private final PublicationRepository publicationRepository;

    public CommentRepository(MongoTemplate mongoTemplate, PublicationRepository publicationRepository) {
        this.mongoTemplate = mongoTemplate;
        this.publicationRepository = publicationRepository;
    }

    public Comment create(Comment comment) {
        Boolean verification = publicationRepository.verifyIfPublicationExists(comment.getPublicationId());
        System.out.println(verification);
        if (!verification) {
            throw new RuntimeException("Publication not found");
        }
        IdGenerator idGenerator = new IdGenerator();
        comment.setId(idGenerator.generateId());
        return mongoTemplate.save(comment);
    }

    public List<Comment> getAllOfPublication(String publicationId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("publicationId").is(publicationId));
        return mongoTemplate.find(query, Comment.class);
    }
}
