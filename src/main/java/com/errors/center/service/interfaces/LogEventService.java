package com.errors.center.service.interfaces;

import com.errors.center.dto.LogEventDTO;
import com.errors.center.model.LogEvent;

import java.util.List;
import java.util.Optional;

public interface LogEventService {
    List<LogEvent> findAll();

    Optional<LogEvent> findById(Long id);

    LogEvent save(LogEventDTO logEvent);

    void deleteById(Long id);
}
