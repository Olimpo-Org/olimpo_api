package com.example.olimpoapi.service;

import com.example.olimpoapi.repository.PublicationRepository;

public class PublicationService {
    private final PublicationRepository publicationRepository;
    private PublicationService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

}