package com.gg.biddingsystem.app.controller;

import com.gg.biddingsystem.app.models.AppUser;
import com.gg.biddingsystem.app.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Register a new user
    @PostMapping
    public ResponseEntity<AppUser> registerUser(@RequestBody AppUser user) {
        AppUser registeredUser = userService.saveUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    // Get user details by ID
    @GetMapping("/{userId}")
    public ResponseEntity<Optional<AppUser>> getUserById(@PathVariable Long userId) {
        Optional<AppUser> user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }
}
