package com.example.olimpoapi.repository.jpa;

import com.example.olimpoapi.model.postgres.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community, String> {
}
