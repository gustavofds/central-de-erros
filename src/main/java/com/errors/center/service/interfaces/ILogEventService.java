package com.errors.center.service.interfaces;

import com.errors.center.dto.LogEventDTO;
import com.errors.center.exceptions.NotFoundException;
import com.errors.center.model.LogEvent;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ILogEventService {
    List<LogEvent> findAll();

    Optional<LogEvent> findById(Long id);

    LogEvent save(LogEventDTO logEvent);

    void deleteById(Long id);

    List<LogEvent> filterByDescription(String descriptionEvent);

    List<LogEvent> filterByLogEvent(String logEvent);

    List<LogEvent> filterByOrigin(String origin);

    List<LogEvent> filterByDate(String date);

    List<LogEvent> filterByQuantity(int quantity);

    List<LogEvent> filterByLevelType(String levelName);
}
