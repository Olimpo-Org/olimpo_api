package com.example.olimpoapi.repository.feedFlow;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.mongo.Publication;
import com.example.olimpoapi.utils.IdGenerator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class PublicationRepository {

    private final MongoTemplate mongoTemplate;

    public PublicationRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Publication create(Publication publication) {
        IdGenerator idGenerator = new IdGenerator();
        publication.setPublicationId(idGenerator.generateId());
        return mongoTemplate.save(publication);
    }

    public List<Publication> getAllOfCommunity(String communityId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("communityId").is(communityId));
        return mongoTemplate.find(query, Publication.class);
    }

    public boolean verifyIfPublicationExists(String id) {
        return mongoTemplate.exists(Query.query(Criteria.where("publicationId").is(id)), Publication.class);
    }

    public List<String> likePublication(String publicationId, String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("publicationId").is(publicationId));
        query.addCriteria(Criteria.where("likes").is(userId));
        if (mongoTemplate.exists(query, Publication.class)) {
            ExceptionThrower.throwBadRequestException("This publication has already been liked");
        }
        Query query2 = new Query();
        query2.addCriteria(Criteria.where("publicationId").is(publicationId));
        Update update = new Update();
        update.push("likes", userId);
        return Objects.requireNonNull(mongoTemplate.findAndModify(query2, update, Publication.class)).getLikes();
    }

    public List<String> unlikePublication(String publicationId, String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("publicationId").is(publicationId));
        query.addCriteria(Criteria.where("likes").is(userId));
        if (!mongoTemplate.exists(query, Publication.class)) {
            ExceptionThrower.throwBadRequestException("This publication has not been liked yet");
        }
        Query query2 = new Query();
        query2.addCriteria(Criteria.where("publicationId").is(publicationId));
        Update update = new Update();
        update.pull("likes", userId);
        return Objects.requireNonNull(mongoTemplate.findAndModify(query2, update, Publication.class)).getLikes();
    }

}
