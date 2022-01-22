package com.errors.center.controller;

import com.errors.center.model.LogEvent;
import com.errors.center.service.LogEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logevent")
public class LogEventController {

    @Autowired
    private LogEventService logEventService;

    @PostMapping
    public LogEvent save(@RequestBody LogEvent logEvent) {
        return this.logEventService.save(logEvent);
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
