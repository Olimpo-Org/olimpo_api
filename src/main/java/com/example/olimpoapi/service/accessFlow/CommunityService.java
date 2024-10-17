package com.example.olimpoapi.service.accessFlow;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.postgresql.Community;
import com.example.olimpoapi.model.postgresql.CommunityUser;
import com.example.olimpoapi.model.postgresql.User;
import com.example.olimpoapi.model.utils.CommunityUserId;
import com.example.olimpoapi.repository.accessFlow.CommunityRepository;
import com.example.olimpoapi.repository.accessFlow.CommunityUserRepository;
import com.example.olimpoapi.repository.accessFlow.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommunityService {
    private final CommunityRepository communityRepository;
    private final CommunityUserRepository communityUserRepository;
    private final UserRepository userRepository;
    @Autowired
    private CommunityService(
            CommunityRepository communityRepository,
            CommunityUserRepository communityUserRepository,
            UserRepository userRepository
    ) {
        this.communityRepository = communityRepository;
        this.communityUserRepository = communityUserRepository;
        this.userRepository = userRepository;
    }

    public Community save(Community community) {
        return communityRepository.save(community);
    }

    public List<Community> getAll() {
        try {
            List<Community> communities = communityRepository.findAll();
            if (communities.isEmpty()) {
                ExceptionThrower.throwNotFoundException("Communities not found");
            }
            return communities;
        }catch (Exception e) {
            ExceptionThrower.throwBadRequestException(e.getMessage());
        }
        return null;
    }

    public Community findById(Long id) {
        Optional<Community> community = communityRepository.findById(id);
        if(community.isEmpty()) {
            ExceptionThrower.throwNotFoundException("Community not found");
        }
        return community.get();
    }

    public boolean verifyIfCommunityExists(Long id) {
        Optional<Community> community = communityRepository.findById(id);
        return community.isPresent();
    }
    public CommunityUser addUserToCommunity(Long customerId, Long communityId) {
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
            return false;
        }
        return true;
    }

    public List<User> getAllUsersByCommunityId(Long communityId) {
        if (!verifyIfCommunityExists(communityId)) ExceptionThrower.throwNotFoundException("Community not found");
        List<CommunityUser> communityUsers = communityUserRepository
                .findAllByIdCommunityId(communityId);
        if (communityUsers.isEmpty()) {
            ExceptionThrower.throwNotFoundException("CommunityUsers not found");
        }
        List<User> users = new ArrayList<>();
        for (CommunityUser communityUser : communityUsers) {
            Optional<User> user = userRepository.findById(communityUser.getId().getCustomerId());
            if (user.isPresent()) {
                user.get().setPassword(null);
                users.add(user.get());
            }

        }
        return users;
    }

    public List<Community> getAllCommunitiesByUserId(Long customerId) {
        List<CommunityUser> communityUsers = communityUserRepository
                .findAllByIdCustomerId(customerId);
        if (communityUsers.isEmpty()) {
            ExceptionThrower.throwNotFoundException("CommunityUsers not found");
        }
        List<Community> communities = new ArrayList<>();
        for (CommunityUser communityUser : communityUsers) {
            Optional<Community> community = communityRepository.findById(communityUser.getId().getCommunityId());
            if (community.isPresent()) {
                communities.add(community.get());
            }
        }
        return communities;
    }
}
