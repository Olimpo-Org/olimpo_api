package com.example.olimpoapi.repository.mongo;

import com.example.olimpoapi.model.mongo.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PublicationRepository extends MongoRepository<Publication, String> {
}
