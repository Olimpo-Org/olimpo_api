package com.example.olimpoapi.repository.mongo;

import com.example.olimpoapi.model.mongo.Publication;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PublicationRepository extends MongoRepository<Publication, String> {

    List<Publication> findAllByCommunityId(String communityId);
}
