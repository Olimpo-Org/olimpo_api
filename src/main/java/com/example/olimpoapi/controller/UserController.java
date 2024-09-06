package com.example.olimpoapi.controller;

import com.example.olimpoapi.model.postgres.User;
import com.example.olimpoapi.model.utils.Login;
import com.example.olimpoapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.validation.Validator;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private final UserService userService;
    private Validator validator;
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
    public ResponseEntity save(@RequestBody User user) {
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
    @GetMapping("/get/{id}")
    public ResponseEntity getById(@PathVariable String id) {
            return ResponseEntity.ok().body(
                    userService.getById(id)
            );
    }
}
