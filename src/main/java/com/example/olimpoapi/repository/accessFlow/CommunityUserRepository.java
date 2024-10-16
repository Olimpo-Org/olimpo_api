package com.example.olimpoapi.repository.accessFlow;

import com.example.olimpoapi.model.postgresql.CommunityUser;
import com.example.olimpoapi.model.utils.CommunityUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CommunityUserRepository extends JpaRepository<CommunityUser, Long> {
    CommunityUser findCommunityUserById(CommunityUserId communityUserId);
}
