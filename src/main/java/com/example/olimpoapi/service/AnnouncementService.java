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
        return announcementRepository.save(announcement);
    }

    public List<Announcement> getAllOfCommunity(String communityId) {
        return announcementRepository.findAllByCommunityId(communityId);
    }

    public List<Announcement> getAllServices(String communityId) {
        List<Announcement> announcements = getAllOfCommunity(communityId);
        announcements.removeIf(announcement -> !announcement.getType().equals("service"));
        return announcements;
    }

    public List<Announcement> getAllSales(String communityId) {
        List<Announcement> announcements = getAllOfCommunity(communityId);
        announcements.removeIf(announcement -> !announcement.getType().equals("sale"));
        return announcements;
    }

    public List<Announcement> getAllDonations(String communityId) {
        List<Announcement> announcements = getAllOfCommunity(communityId);
        announcements.removeIf(announcement -> !announcement.getType().equals("donation"));
        return announcements;
    }



}
