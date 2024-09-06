package com.example.olimpoapi.service;

import com.example.olimpoapi.repository.mongo.AnnouncementRepository;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private AnnouncementService(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

}
