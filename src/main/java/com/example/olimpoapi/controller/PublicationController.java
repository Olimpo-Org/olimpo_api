package com.example.olimpoapi.controller;

import com.example.olimpoapi.model.mongo.Publication;
import com.example.olimpoapi.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.validation.Validator;
import java.util.List;

@RestController
@RequestMapping("/v1/publication")
public class PublicationController {
    private final PublicationService publicationService;
    private Validator validator;
    @Autowired
    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Publication publication, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors().get(0).getDefaultMessage());
        }
        Publication createdPublication = publicationService.create(publication);
        return ResponseEntity.ok().body(createdPublication.toString());
    }
    @GetMapping("/get/{communityId}")
    public ResponseEntity<String> getAllOfCommunity(@PathVariable("communityId") String communityId) {
        List<Publication> publications = publicationService.getAllOfCommunity(communityId);
        return ResponseEntity.ok().body(publications.toString());
    }

}
