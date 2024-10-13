package com.example.olimpoapi.controller.accessFlow;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.postgresql.Administrator;
import com.example.olimpoapi.model.postgresql.User;
import com.example.olimpoapi.model.utils.Login;
import com.example.olimpoapi.service.accessFlow.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Login login) {
        return ResponseEntity.ok().body(
                userService.login(login)
        );
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            ExceptionThrower.throwBadRequestException(result.getAllErrors().get(0).getDefaultMessage());
        }
        return ResponseEntity.ok().body(
                userService.save(user)
        );
    }

    @GetMapping("/get")
    public ResponseEntity getAll() {
            return ResponseEntity.ok().body(
                    userService.getAll()
            );
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
            return ResponseEntity.ok().body(
                    userService.findById(id)
            );
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity getByEmail(@PathVariable String email) {
        return ResponseEntity.ok().body(
                userService.findByEmail(email)
        );
    }

    @GetMapping("/getByCpf/{cpf}")
    public ResponseEntity getByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok().body(
                userService.findByCpf(cpf)
        );
    }

    @GetMapping("/userExists/byEmail/{email}")
    public ResponseEntity verifyIfUserExistsByEmail(@PathVariable String email) {
        return ResponseEntity.ok().body(
                userService.verifyIfUserExistsByEmail(email)
        );
    }

    @GetMapping("/userExists/byCpf/{cpf}")
    public ResponseEntity verifyIfUserExistsByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok().body(
                userService.verifyIfUserExistsByCpf(cpf)
        );
    }

    @PostMapping("/grantAdministrator")
    public ResponseEntity grantAdministrator(@RequestBody Administrator administrator, BindingResult result) {
        if (result.hasErrors()) {
            ExceptionThrower.throwBadRequestException(result.getAllErrors().get(0).getDefaultMessage());
        }
        return ResponseEntity.ok().body(
                userService.grantAdministrator(administrator)
        );
    }

    @GetMapping("/verifyIfIsAdministrator/{customerId}/{communityId}")
    public ResponseEntity verifyIfIsAdministrator(
            @PathVariable String customerId,
            @PathVariable Long communityId
            ) {
        return ResponseEntity.ok().body(
                userService.verifyIfIsAdministrator(customerId, communityId)
        );
    }
}
