package com.example.olimpoapi.service.feedFlow;

import com.example.olimpoapi.model.mongo.Publication;
import com.example.olimpoapi.repository.feedFlow.PublicationRepository;
import com.example.olimpoapi.utils.IdGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService {
    private final PublicationRepository publicationRepository;
    private PublicationService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }
    public Publication create(Publication publication) {
        IdGenerator idGenerator = new IdGenerator();
        publication.setPublicationId(idGenerator.generateId());
        return publicationRepository.create(publication);
    }

    public List<Publication> getAllOfCommunity(String communityId) {
        return publicationRepository.getAllOfCommunity(communityId);
    }

    public List<Publication> getAllOfUser(String communityId, String userId) {
        return publicationRepository.getAllOfUser(communityId, userId);
    }

    public boolean verifyIfPublicationExists(String id) {
        return publicationRepository.verifyIfPublicationExists(id);
    }

    public List<String> likePublication(String publicationId, String userId) {
        return publicationRepository.likePublication(publicationId, userId);
    }

    public List<String> unlikePublication(String publicationId, String userId) {
        return publicationRepository.unlikePublication(publicationId, userId);
    }

}
