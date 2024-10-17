package com.example.olimpoapi.controller.accessFlow;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.postgresql.Community;
import com.example.olimpoapi.model.postgresql.CommunityUser;
import com.example.olimpoapi.model.postgresql.User;
import com.example.olimpoapi.service.accessFlow.CommunityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Criar nova Comunidade", description = "Endpoint cria uma nova a partir de um objeto JSON")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comunidade criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping("/save")
    public ResponseEntity<Community> save( @RequestBody Community community, BindingResult result) {
        if (result.hasErrors()) {
            ExceptionThrower.throwBadRequestException(result.getAllErrors().get(0).getDefaultMessage());
        }
        return ResponseEntity.ok().body(
                communityService.save(community)
        );
    }

    @Operation(summary = "Listar todas as Comunidades", description = "Endpoint lista todas as comunidades")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comunidades retornadas com sucesso")
    })
    @GetMapping("/getAll")
    public ResponseEntity<List<Community>> getAll() {
        return ResponseEntity.ok().body(
                communityService.getAll()
        );
    }

    @Operation(summary = "Listar uma Comunidade pelo ID", description = "Endpoint lista uma comunidade pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comunidade retornada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Comunidade não encontrada")
    })
    @GetMapping("/getById/{id}")
    public ResponseEntity<Community> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(
                communityService.findById(id)
        );
    }

    @Operation(summary = "Adicionar um Usuário a uma Comunidade", description = "Endpoint adiciona um Usuário a uma Comunidade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comunidade adicionada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Comunidade ou Usuário não encontrados")
    })
    @PostMapping("/addUserToCommunity/{communityId}/{customerId}")
    public ResponseEntity<CommunityUser> addUserToCommunity(@PathVariable Long communityId, @PathVariable Long customerId) {
        return ResponseEntity.ok().body(
                communityService.addUserToCommunity(customerId, communityId)
        );
    }

    @Operation(summary = "Remover um Usuário de uma Comunidade", description = "Endpoint remove um Usuário de uma Comunidade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comunidade removida com sucesso"),
            @ApiResponse(responseCode = "400", description = "Comunidade ou Usuário não encontrados")
    })
    @DeleteMapping("/removeUserFromCommunity/{communityId}/{customerId}")
    public ResponseEntity<CommunityUser> removeUserFromCommunity(@PathVariable Long communityId, @PathVariable Long customerId) {
        return ResponseEntity.ok().body(
                communityService.removeUserFromCommunity(communityId, customerId)
        );
    }

    @Operation(summary = "Verificar se um Usuário está em uma Comunidade", description = "Endpoint verifica se um Usuário está em uma Comunidade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Valor booleano retornado com sucesso"),
    })
    @GetMapping("/verifyIfUserIsInCommunity/{communityId}/{customerId}")
    public ResponseEntity<Boolean> verifyIfUserIsInCommunity(@PathVariable Long communityId, @PathVariable Long customerId) {
        return ResponseEntity.ok().body(
                communityService.verifyIfUserIsInCommunity(customerId, communityId)
        );
    }

    @Operation(summary = "Listar todos os Usuários de uma Comunidade", description = "Endpoint lista todos os Usuários de uma Comunidade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comunidade retornada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Comunidade não encontrada"),
            @ApiResponse(responseCode = "404", description = "Nenhum Usuário encontrado na Comunidade")
    })
    @GetMapping("/getAllUsersInCommunity/{communityId}")
    public ResponseEntity<List<User>> getAllUsersInCommunity(@PathVariable Long communityId) {
        return ResponseEntity.ok().body(
                communityService.getAllUsersByCommunityId(communityId)
        );
    }

    @Operation(summary = "Listar todas as Comunidades de um Usuário", description = "Endpoint lista todas as Comunidades de um Usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comunidades retornadas com sucesso"),
            @ApiResponse(responseCode = "404", description = "Comunidade não encontrada"),
            @ApiResponse(responseCode = "404", description = "Nenhum Usuário encontrado na Comunidade")
    })
    @GetMapping("/getAllCommunitiesByUser/{customerId}")
    public ResponseEntity<List<Community>> getAllCommunitiesByUser(@PathVariable Long customerId) {
        return ResponseEntity.ok().body(
                communityService.getAllCommunitiesByUserId(customerId)
        );
    }

    @Operation(summary = "Verificar se uma Comunidade existe", description = "Endpoint verifica se uma Comunidade existe")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorno booleano com sucesso"),
    })
    @GetMapping("/verifyIfCommunityExists/{id}")
    public ResponseEntity<Boolean> verifyIfCommunityExists(@PathVariable Long id) {
        return ResponseEntity.ok().body(
                communityService.verifyIfCommunityExists(id)
        );
    }
}
