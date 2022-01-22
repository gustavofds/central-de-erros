package com.errors.center.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
public class LogEventController {

    @PostMapping("/log")
    ResponseEntity<Object> recordEvent(@RequestBody Object log) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(log);
    }
}
