package com.example.olimpoapi.controller.negotiationFlow;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.mongo.Announcement;
import com.example.olimpoapi.service.negotiationFlow.AnnouncementService;
import com.example.olimpoapi.utils.GsonUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Announcement", description = "Endpoints de anuncio")
@RequestMapping("/v1/announcement")
public class AnnouncementController {
    private final AnnouncementService announcementService;
    private final GsonUtils gsonUtils;
    @Autowired
    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
        this.gsonUtils = new GsonUtils();
    }

    @Operation(summary = "Criar novo anuncio", description = "Endpoint cria uma nova a partir de um objeto JSON")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Anuncio criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping("/create")
    public ResponseEntity<String> create(
            @Parameter(description = "Anuncio a ser criado")
            @Valid @RequestBody Announcement announcement, BindingResult result
    ) {
        if (result.hasErrors()) {
            ExceptionThrower.throwBadRequestException(result.getAllErrors().get(0).getDefaultMessage());
        }
        Announcement createdAnnouncement = announcementService.create(announcement);
        return ResponseEntity.ok().body(gsonUtils.toJson(createdAnnouncement));
    }

    @Operation(summary = "Listar todos os anuncios de uma comunidade", description = "Endpoint lista todos os anuncios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Anuncios retornados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Anuncios não encontrados")
    })
    @GetMapping("/get/{communityId}")
    public ResponseEntity<String> getAllOfCommunity(
            @Parameter(description = "Id da comunidade")
            @PathVariable("communityId") String communityId
    ) {
        List<Announcement> announcements = announcementService.getAllOfCommunity(communityId);
        return ResponseEntity.ok().body(gsonUtils.toJson(announcements));
    }

    @Operation(
            summary = "Listar todos os servicos de uma comunidade",
            description = "Endpoint lista todos os anuncios filtrados por servicos"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Anuncios retornados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Anuncios não encontrados")
    })
    @GetMapping("/get/services/{communityId}")
    public ResponseEntity<String> getAllServices(
            @PathVariable("communityId") String communityId
    ) {
        List<Announcement> announcements = announcementService.getAllServices(communityId);
        return ResponseEntity.ok().body(gsonUtils.toJson(announcements));
    }

    @Operation(
            summary = "Listar todos os vendas de uma comunidade",
            description = "Endpoint lista todos os anuncios filtrados por vendas"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Anuncios retornados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Anuncios não encontrados")
    })
    @GetMapping("/get/sales/{communityId}")
    public ResponseEntity<String> getAllSales(
            @PathVariable("communityId") String communityId
    ) {
        List<Announcement> announcements = announcementService.getAllSales(communityId);
        return ResponseEntity.ok().body(gsonUtils.toJson(announcements));
    }

    @Operation(
            summary = "Listar todos as doações de uma comunidade",
            description = "Endpoint lista todos os anuncios filtrados por doações"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Anuncios retornados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Anuncios não encontrados")
    })
    @GetMapping("/get/donations/{communityId}")
    public ResponseEntity<String> getAllDonations(
            @PathVariable("communityId") String communityId
    ) {
        List<Announcement> announcements = announcementService.getAllDonations(communityId);
        return ResponseEntity.ok().body(gsonUtils.toJson(announcements));
    }
}