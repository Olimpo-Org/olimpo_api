package com.example.olimpoapi.service;

import com.example.olimpoapi.model.mongo.Announcement;
import com.example.olimpoapi.repository.mongo.AnnouncementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private AnnouncementService(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    public Announcement create(Announcement announcement) {
        return announcementRepository.create(announcement);
    }

    public List<Announcement> getAllServices(String communityId) {
        return announcementRepository.getAllServicesOfCommunity(communityId);
    }

    public List<Announcement> getAllSales(String communityId) {
        return announcementRepository.getAllSalesOfCommunity(communityId);
    }

    public List<Announcement> getAllDonations(String communityId) {
        return announcementRepository.getAllDonationsOfCommunity(communityId);
    }

    public List<Announcement> getAllOfCommunity(String communityId) {
        return announcementRepository.getAllOfCommunity(communityId);
    }

}
