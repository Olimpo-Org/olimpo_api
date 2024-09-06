package com.example.olimpoapi.repository.mongo;

import com.example.olimpoapi.model.mongo.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnnouncementRepository extends MongoRepository<Announcement, String> {
}
