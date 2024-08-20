package com.example.olimpoapi.service;

import com.example.olimpoapi.repository.CommunityRepository;

public class CommunityService {
    private final CommunityRepository communityRepository;
    private CommunityService(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }
}
