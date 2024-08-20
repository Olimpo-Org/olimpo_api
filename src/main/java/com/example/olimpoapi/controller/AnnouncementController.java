package com.example.olimpoapi.controller;

import com.example.olimpoapi.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.validation.Validator;

@RestController
@RequestMapping("/v1/announcement")
public class AnnouncementController {
    private final AnnouncementService announcementService;
    private Validator validator;
    @Autowired
    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }
}
