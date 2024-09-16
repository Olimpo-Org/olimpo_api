package com.example.olimpoapi.repository.mongo;

import com.example.olimpoapi.model.mongo.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatRepository extends MongoRepository<Chat, String> {

    List<Chat> findAllByCommunityId(String communityId);
}
