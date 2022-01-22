package com.errors.center.controller;

import com.errors.center.dto.LogEventDTO;
import com.errors.center.model.LevelType;
import com.errors.center.model.LogEvent;
import com.errors.center.service.interfaces.LogEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/logevent")
public class LogEventController {

    @Autowired
    private LogEventService logEventService;

    @PostMapping
    public LogEvent save(@RequestBody LogEventDTO log) {
        return this.logEventService.save(log);
    }

    @GetMapping
    public Iterable<LogEvent> findAll() {
        return this.logEventService.findAll();
    }

    @GetMapping("/{id}")
    public LogEvent findById(@PathVariable("id") Long id) {
        return this.logEventService.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.logEventService.deleteById(id);
    }
}
