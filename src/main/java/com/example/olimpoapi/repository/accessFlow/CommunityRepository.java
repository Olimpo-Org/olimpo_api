package com.example.olimpoapi.repository.accessFlow;

import com.example.olimpoapi.model.postgresql.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CommunityRepository extends JpaRepository<Community, Long> {
}
