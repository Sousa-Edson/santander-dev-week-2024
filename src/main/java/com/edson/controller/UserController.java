package com.edson.controller;

import com.edson.domain.model.User;
import com.edson.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    ResponseEntity<User> finddyId(@PathVariable Long id) {
        var user = userService.finddyId(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    ResponseEntity<User> create(@RequestBody User useToCreate) {
        var userCreated = userService.create(useToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userCreated.getId()).toUri();
        return ResponseEntity.created(location).body(userCreated);
    }
}
