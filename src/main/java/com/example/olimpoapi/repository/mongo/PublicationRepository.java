package com.example.olimpoapi.repository.mongo;

import com.example.olimpoapi.model.mongo.Publication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PublicationRepository {

    private final MongoTemplate mongoTemplate;

    public PublicationRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Publication create(Publication publication) {
        publication.setId(String.valueOf(System.currentTimeMillis()));
        return mongoTemplate.save(publication);
    }

    public List<Publication> getAllOfCommunity(String communityId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("communityId").is(communityId));
        return mongoTemplate.find(query, Publication.class);
    }

    public boolean verifyIfPublicationExists(String id) {
        return mongoTemplate.exists(Query.query(Criteria.where("id").is(id)), Publication.class);
    }

}
