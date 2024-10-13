package com.example.olimpoapi.repository.accessFlow;

import com.example.olimpoapi.model.postgresql.CommunityUser;
import com.example.olimpoapi.model.utils.CommunityUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CommunityUserRepository extends JpaRepository<CommunityUser, CommunityUserId> {
    CommunityUser findCommunityUserById(CommunityUserId communityUserId);
    List<CommunityUser> findAllByIdCommunityId(Long communityId);
}
