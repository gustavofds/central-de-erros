package com.errors.center.controller;

import com.errors.center.dto.UserDTO;
import com.errors.center.model.User;
import com.errors.center.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    ResponseEntity<UserDTO> save(@RequestBody User user) {
        User newUser = service.save(user);
        UserDTO response = new UserDTO(newUser.getId(), newUser.getLogin());

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @GetMapping
    ResponseEntity<User> findByLogin(String login) {
        User response = service.findByLogin(login);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }
}
