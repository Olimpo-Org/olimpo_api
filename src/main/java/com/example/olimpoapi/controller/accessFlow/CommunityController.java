package com.example.olimpoapi.controller.accessFlow;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.postgresql.Community;
import com.example.olimpoapi.model.postgresql.CommunityUser;
import com.example.olimpoapi.model.postgresql.User;
import com.example.olimpoapi.service.accessFlow.CommunityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/community")
public class CommunityController {
    private final CommunityService communityService;
    @Autowired
    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @PostMapping("/save")
    public ResponseEntity<Community> save( @RequestBody Community community, BindingResult result) {
        if (result.hasErrors()) {
            ExceptionThrower.throwBadRequestException(result.getAllErrors().get(0).getDefaultMessage());
        }
        return ResponseEntity.ok().body(
                communityService.save(community)
        );
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Community>> getAll() {
        return ResponseEntity.ok().body(
                communityService.getAll()
        );
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Community> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(
                communityService.findById(id)
        );
    }

    @PostMapping("/addUserToCommunity/{communityId}/{customerId}")
    public ResponseEntity<CommunityUser> addUserToCommunity(@PathVariable Long communityId, @PathVariable Long customerId) {
        return ResponseEntity.ok().body(
                communityService.addUserToCommunity(customerId, communityId)
        );
    }

    @GetMapping("/verifyIfUserIsInCommunity/{communityId}/{customerId}")
    public ResponseEntity<Boolean> verifyIfUserIsInCommunity(@PathVariable Long communityId, @PathVariable Long customerId) {
        return ResponseEntity.ok().body(
                communityService.verifyIfUserIsInCommunity(customerId, communityId)
        );
    }

    @GetMapping("/getAllUsersInCommunity/{communityId}")
    public ResponseEntity<List<User>> getAllUsersInCommunity(@PathVariable Long communityId) {
        return ResponseEntity.ok().body(
                communityService.getAllUsersByCommunityId(communityId)
        );
    }

    //UTILS
    @GetMapping("/verifyIfCommunityExists/{id}")
    public ResponseEntity<Boolean> verifyIfCommunityExists(@PathVariable Long id) {
        return ResponseEntity.ok().body(
                communityService.verifyIfCommunityExists(id)
        );
    }
    @DeleteMapping("/removeUserFromCommunity/{communityId}/{customerId}")
    public ResponseEntity<CommunityUser> removeUserFromCommunity(@PathVariable Long communityId, @PathVariable Long customerId) {
        return ResponseEntity.ok().body(
                communityService.removeUserFromCommunity(communityId, customerId)
        );
    }
}
