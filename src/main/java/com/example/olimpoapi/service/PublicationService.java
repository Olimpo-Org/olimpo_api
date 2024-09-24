package com.example.olimpoapi.service;

import com.example.olimpoapi.model.mongo.Publication;
import com.example.olimpoapi.repository.mongo.PublicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService {
    private final PublicationRepository publicationRepository;
    private PublicationService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }
    public Publication create(Publication publication) {
        return publicationRepository.save(publication);
    }
    public List<Publication> getAllOfCommunity(String communityId) {
        return publicationRepository.findAllByCommunityId(communityId);
    }
    public boolean verifyIfPublicationExists(String id) {
        return publicationRepository.existsById(id);
    }
}
