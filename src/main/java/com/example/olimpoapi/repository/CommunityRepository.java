package com.example.olimpoapi.repository;

import com.example.olimpoapi.model.mongo.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community, String> {
}
