package com.example.olimpoapi.controller.feedFlow;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.mongo.Publication;
import com.example.olimpoapi.service.feedFlow.PublicationService;
import com.example.olimpoapi.utils.GsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/publication")
public class PublicationController {
    private final PublicationService publicationService;
    private final GsonUtils gsonUtils;
    @Autowired
    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
        this.gsonUtils = new GsonUtils();
    }
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Publication publication, BindingResult result) {
        if (result.hasErrors()) {
            ExceptionThrower.throwBadRequestException(result.getAllErrors().get(0).getDefaultMessage());
        }
        Publication createdPublication = publicationService.create(publication);
        return ResponseEntity.ok().body(gsonUtils.toJson(createdPublication));
    }
    @GetMapping("/get/{communityId}")
    public ResponseEntity<String> getAllOfCommunity(@PathVariable("communityId") String communityId) {
        List<Publication> publications = publicationService.getAllOfCommunity(communityId);
        return ResponseEntity.ok().body(gsonUtils.toJson(publications));
    }

}
