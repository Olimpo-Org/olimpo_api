package com.example.olimpoapi.controller.accessFlow;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.postgresql.Administrator;
import com.example.olimpoapi.model.postgresql.User;
import com.example.olimpoapi.model.utils.Login;
import com.example.olimpoapi.service.accessFlow.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "User", description = "Endpoints de Usuário")
@RequestMapping("/v1/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Realizar Login", description = "Endpoint realiza o login de um usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login realizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Senha ou email inválidos"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),

    })
    @PostMapping("/login")
    public ResponseEntity login(
            @Parameter(description = "JSON com os dados de login")
            @RequestBody Login login
    ) {
        return ResponseEntity.ok().body(
                userService.login(login)
        );
    }

    @Operation(summary = "Criar novo Usuário", description = "Endpoint cria uma nova a partir de um objeto JSON")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping("/save")
    public ResponseEntity save(
            @Parameter(description = "JSON com os dados do usuário")
            @RequestBody User user, BindingResult result
    ) {
        if (result.hasErrors()) {
            ExceptionThrower.throwBadRequestException(result.getAllErrors().get(0).getDefaultMessage());
        }
        return ResponseEntity.ok().body(
                userService.save(user)
        );
    }
    @Operation(summary = "Listar todos os Usuários", description = "Endpoint lista todos os usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuários retornados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuários não encontrados")
    })
    @GetMapping("/get")
    public ResponseEntity getAll() {
            return ResponseEntity.ok().body(
                    userService.getAll()
            );
    }

    @Operation(summary = "Listar um Usuário pelo ID", description = "Endpoint lista um usuário pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário retornado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @GetMapping("/getById/{id}")
    public ResponseEntity getById(
            @Parameter(description = "ID do Usuário")
            @PathVariable Long id
    ) {
            return ResponseEntity.ok().body(
                    userService.findById(id)
            );
    }

    @Operation(summary = "Listar um Usuário pelo Email", description = "Endpoint lista um usuário pelo Email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário retornado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @GetMapping("/getByEmail/{email}")
    public ResponseEntity getByEmail(
            @Parameter(description = "Email do Usuário")
            @PathVariable String email
    ) {
        return ResponseEntity.ok().body(
                userService.findByEmail(email)
        );
    }

    @Operation(summary = "Listar um Usuário pelo Cpf", description = "Endpoint lista um usuário pelo Cpf")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário retornado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @GetMapping("/getByCpf/{cpf}")
    public ResponseEntity getByCpf(
            @Parameter(description = "Cpf do Usuário")
            @PathVariable String cpf
    ) {
        return ResponseEntity.ok().body(
                userService.findByCpf(cpf)
        );
    }

    @Operation(summary = "Listar um Usuário pelo Email", description = "Endpoint lista um usuário pelo Email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário retornado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @GetMapping("/userExists/byEmail/{email}")
    public ResponseEntity verifyIfUserExistsByEmail(
            @Parameter(description = "Email do Usuário")
            @PathVariable String email
    ) {
        return ResponseEntity.ok().body(
                userService.verifyIfUserExistsByEmail(email)
        );
    }

    @Operation(summary = "Listar um Usuário pelo Cpf", description = "Endpoint lista um usuário pelo Cpf")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário retornado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @GetMapping("/userExists/byCpf/{cpf}")
    public ResponseEntity verifyIfUserExistsByCpf(
            @Parameter(description = "Cpf do Usuário")
            @PathVariable String cpf
    ) {
        return ResponseEntity.ok().body(
                userService.verifyIfUserExistsByCpf(cpf)
        );
    }

    @Operation(summary = "Dar permissão de administrador", description = "Endpoint da permissão de administrador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Administrador criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping("/grantAdministrator")
    public ResponseEntity grantAdministrator(
            @Parameter(description = "Administrador a ser criado")
            @RequestBody Administrator administrator, BindingResult result
    ) {
        if (result.hasErrors()) {
            ExceptionThrower.throwBadRequestException(result.getAllErrors().get(0).getDefaultMessage());
        }
        return ResponseEntity.ok().body(
                userService.grantAdministrator(administrator)
        );
    }

    @Operation(summary = "Verificar se o Usuário é administrador", description = "Endpoint verifica se o Usuário é administrador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Administrador criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping("/verifyIfIsAdministrator")
    @GetMapping("/verifyIfIsAdministrator/{customerId}/{communityId}")
    public ResponseEntity verifyIfIsAdministrator(
            @Parameter(description = "ID do Usuário")
            @PathVariable String customerId,
            @Parameter(description = "ID da comunidade")
            @PathVariable Long communityId
            ) {
        return ResponseEntity.ok().body(
                userService.verifyIfIsAdministrator(customerId, communityId)
        );
    }
}
