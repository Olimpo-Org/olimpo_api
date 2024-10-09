package com.example.olimpoapi.service.accessFlow;

//import com.example.olimpoapi.config.exception.ExceptionThrower;
//import com.example.olimpoapi.model.postgresql.Community;
//import com.example.olimpoapi.model.postgresql.CommunityUser;
//import com.example.olimpoapi.repository.accessFlow.CommunityRepository;
//import com.example.olimpoapi.repository.accessFlow.CommunityUserRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;

//@Service
//public class CommunityService {
//    private final CommunityRepository communityRepository;
//    private final CommunityUserRepository communityUserRepository;
//    private CommunityService(
//            CommunityRepository communityRepository,
//            CommunityUserRepository communityUserRepository
//    ) {
//        this.communityRepository = communityRepository;
//        this.communityUserRepository = communityUserRepository;
//    }
//    public List<Community> getAll() {
//        List<Community> communities = communityRepository.findAll();
//        if(communities.isEmpty()) {
//            ExceptionThrower.throwNotFoundException("Communities not found");
//        }
//        return communities;
//    }
//
//    public Community findById(String id) {
//        Optional<Community> community = communityRepository.findById(id);
//        if(community.isEmpty()) {
//            ExceptionThrower.throwNotFoundException("Community not found");
//        }
//        return community.get();
//    }
//
//    public Community save(Community community) {
//        return communityRepository.save(community);
//    }
//
//    public boolean verifyIfCommunityExists(String id) {
//        Optional<Community> community = communityRepository.findById(id);
//        if (community.isEmpty()) {
//            ExceptionThrower.throwNotFoundException("Community not found");
//        }
//        return true;
//    }
//    public CommunityUser addUserToCommunity(String communityId, String customerId) {
//        CommunityUser communityUser = new CommunityUser(customerId, communityId);
//        return communityUserRepository.save(communityUser);
//    }
//
//    public CommunityUser removeUserFromCommunity(String communityId, String customerId) {
//        CommunityUser communityUser = communityUserRepository.findByCustomerIdAndCommunityId(customerId, communityId);
//        if (communityUser == null) {
//            ExceptionThrower.throwNotFoundException("CommunityUser not found");
//        }
//        communityUserRepository.delete(communityUser);
//        return communityUser;
//    }
//    public boolean verifyIfUserIsInCommunity(String communityId, String customerId) {
//        CommunityUser communityUser = communityUserRepository.findByCustomerIdAndCommunityId(customerId, communityId);
//        if (communityUser == null) {
//            ExceptionThrower.throwNotFoundException("CommunityUser not found");
//        }
//        return true;
//    }
//}
