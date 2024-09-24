package com.example.olimpoapi.controller.negotiationFlow;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.mongo.Announcement;
import com.example.olimpoapi.service.negotiationFlow.AnnouncementService;
import com.example.olimpoapi.utils.GsonUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/announcement")
public class AnnouncementController {
    private final AnnouncementService announcementService;
    private final GsonUtils gsonUtils;
    @Autowired
    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
        this.gsonUtils = new GsonUtils();
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@Valid @RequestBody Announcement announcement, BindingResult result) {
        if (result.hasErrors()) {
            ExceptionThrower.throwBadRequestException(result.getAllErrors().get(0).getDefaultMessage());
        }
        Announcement createdAnnouncement = announcementService.create(announcement);
        return ResponseEntity.ok().body(gsonUtils.toJson(createdAnnouncement));
    }

    @GetMapping("/get/{communityId}")
    public ResponseEntity<String> getAllOfCommunity(
            @PathVariable("communityId") String communityId
    ) {
        List<Announcement> announcements = announcementService.getAllOfCommunity(communityId);
        return ResponseEntity.ok().body(gsonUtils.toJson(announcements));
    }

    @GetMapping("/get/services/{communityId}")
    public ResponseEntity<String> getAllServices(
            @PathVariable("communityId") String communityId
    ) {
        List<Announcement> announcements = announcementService.getAllServices(communityId);
        return ResponseEntity.ok().body(gsonUtils.toJson(announcements));
    }

    @GetMapping("/get/sales/{communityId}")
    public ResponseEntity<String> getAllSales(
            @PathVariable("communityId") String communityId
    ) {
        List<Announcement> announcements = announcementService.getAllSales(communityId);
        return ResponseEntity.ok().body(gsonUtils.toJson(announcements));
    }

    @GetMapping("/get/donations/{communityId}")
    public ResponseEntity<String> getAllDonations(
            @PathVariable("communityId") String communityId
    ) {
        List<Announcement> announcements = announcementService.getAllDonations(communityId);
        return ResponseEntity.ok().body(gsonUtils.toJson(announcements));
    }
}
