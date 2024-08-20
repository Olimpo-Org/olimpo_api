package com.example.olimpoapi.service;

import com.example.olimpoapi.repository.AnnouncementRepository;

public class AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private AnnouncementService(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

}
