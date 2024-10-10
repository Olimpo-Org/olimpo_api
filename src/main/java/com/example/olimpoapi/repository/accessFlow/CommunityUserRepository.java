package com.example.olimpoapi.repository.accessFlow;

import com.example.olimpoapi.model.postgresql.CommunityUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityUserRepository extends JpaRepository<CommunityUser, String> {
    CommunityUser findByCustomerIdAndCommunityId(String customerId, String communityId);
    CommunityUser deleteByCustomerIdAndCommunityId(String customerId, String communityId);
}
