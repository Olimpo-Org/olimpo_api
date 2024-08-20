package com.example.olimpoapi.repository;

import com.example.olimpoapi.model.mongo.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AnnouncementRepository extends JpaRepository<Announcement, String> {
}
