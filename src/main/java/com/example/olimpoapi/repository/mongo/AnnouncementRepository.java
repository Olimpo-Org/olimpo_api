package com.example.olimpoapi.repository.mongo;

import com.example.olimpoapi.model.mongo.Announcement;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AnnouncementRepository extends MongoRepository<Announcement, String> {
    List<Announcement> findAllByCommunityId(String communityId);
}
