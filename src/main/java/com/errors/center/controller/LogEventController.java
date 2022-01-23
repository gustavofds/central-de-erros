package com.errors.center.controller;

import com.errors.center.dto.LogDTO;
import com.errors.center.dto.LogEventDTO;
import com.errors.center.mapper.LogEventMapper;
import com.errors.center.model.LogEvent;
import com.errors.center.service.ILogEventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/logevent")
public class LogEventController {


    @Autowired
    private ILogEventServiceImpl service;

    @Autowired
    private LogEventMapper mapper;

    @PostMapping
    public ResponseEntity<LogEvent> save(@RequestBody LogEventDTO log) {
        LogEvent response = this.service.save(log);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @GetMapping
    public ResponseEntity<List<LogDTO>> findAll(Pageable pageable) {
        List<LogEvent> allLogs = this.service.findAll(pageable);
        List<LogDTO> response = mapper.listMap(allLogs);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogEvent> findById(@PathVariable("id") Long id) {
        LogEvent response = this.service.findById(id).get();
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LogEvent> delete(@PathVariable("id") Long id) {
        LogEvent response = this.service.findById(id).get();
        this.service.deleteById(id);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }
    @GetMapping("/filter")
    public ResponseEntity<List<LogEvent>> filterByField(
        @RequestParam(required = false) String descriptionEvent,
        @RequestParam(required = false) String logEvent,
        @RequestParam(required = false) String origin,
        @RequestParam(required = false) String date,
        @RequestParam(required = false) Integer quantity,
        @RequestParam(required = false) String levelName,
        Pageable pageable
    ) {

        List<LogEvent> response = new ArrayList<>();

        if (descriptionEvent != null) {
            response = this.service.filterByDescription(descriptionEvent, pageable);
        }
        if (logEvent != null) {
            response = this.service.filterByLogEvent(logEvent, pageable);
        }
        if (origin != null) {
            response = this.service.filterByOrigin(origin, pageable);
        }
        if (date != null) {
            response = this.service.filterByDate(date, pageable);
        }
        if (quantity != null) {
            response = this.service.filterByQuantity(quantity, pageable);
        }
        if (levelName != null) {
            response = this.service.filterByLevelType(levelName, pageable);
        }

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }
}
