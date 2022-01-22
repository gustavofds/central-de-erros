package com.errors.center.service;

import com.errors.center.model.LogEvent;

import java.util.List;
import java.util.Optional;

public interface LogEventService {
    List<LogEvent> findAll();

    Optional<LogEvent> findById(Long id);

    LogEvent save(LogEvent logEvent);

    void deleteById(Long id);
}
