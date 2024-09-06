package com.example.olimpoapi.service;

import com.example.olimpoapi.repository.mongo.PublicationRepository;
import org.springframework.stereotype.Service;

@Service
public class PublicationService {
    private final PublicationRepository publicationRepository;
    private PublicationService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

}
