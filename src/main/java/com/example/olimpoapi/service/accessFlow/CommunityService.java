package com.example.olimpoapi.service.accessFlow;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.postgresql.Community;
import com.example.olimpoapi.model.postgresql.CommunityUser;
import com.example.olimpoapi.model.utils.CommunityUserId;
import com.example.olimpoapi.repository.accessFlow.CommunityRepository;
import com.example.olimpoapi.repository.accessFlow.CommunityUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommunityService {
    private final CommunityRepository communityRepository;
    private final CommunityUserRepository communityUserRepository;
    @Autowired
    private CommunityService(
            CommunityRepository communityRepository,
            CommunityUserRepository communityUserRepository
    ) {
        this.communityRepository = communityRepository;
        this.communityUserRepository = communityUserRepository;
    }
    public List<Community> getAll() {
        List<Community> communities = communityRepository.findAll();
        if(communities.isEmpty()) {
            ExceptionThrower.throwNotFoundException("Communities not found");
        }
        return communities;
    }

    public Community findById(Long id) {
        Optional<Community> community = communityRepository.findById(id);
        if(community.isEmpty()) {
            ExceptionThrower.throwNotFoundException("Community not found");
        }
        return community.get();
    }

    public Community save(Community community) {
        return communityRepository.save(community);
    }

    public boolean verifyIfCommunityExists(Long id) {
        Optional<Community> community = communityRepository.findById(id);
        if (community.isEmpty()) {
            ExceptionThrower.throwNotFoundException("Community not found");
        }
        return true;
    }
    public CommunityUser addUserToCommunity(Long communityId, Long customerId) {
        CommunityUserId communityUserId = new CommunityUserId(customerId, communityId);
        CommunityUser communityUser = new CommunityUser(communityUserId);
        return communityUserRepository.save(communityUser);
    }

    public CommunityUser removeUserFromCommunity(Long customerId, Long communityId) {
        CommunityUserId communityUserId = new CommunityUserId(customerId, communityId);
        CommunityUser communityUser = communityUserRepository
                .findCommunityUserById(communityUserId);
        if (communityUser == null) {
            ExceptionThrower.throwNotFoundException("CommunityUser not found");
        }
        communityUserRepository.delete(communityUser);
        return communityUser;
    }
    public boolean verifyIfUserIsInCommunity(Long customerId, Long communityId) {
        CommunityUserId communityUserId = new CommunityUserId(customerId, communityId);
        CommunityUser communityUser = communityUserRepository.findCommunityUserById(communityUserId);
        if (communityUser == null) {
            ExceptionThrower.throwNotFoundException("CommunityUser not found");
        }
        return true;
    }
}
