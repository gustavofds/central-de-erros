package com.errors.center.service.interfaces;

import com.errors.center.dto.LogEventDTO;
import com.errors.center.exceptions.NotFoundException;
import com.errors.center.model.LogEvent;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ILogEventService {
    List<LogEvent> findAll(Pageable pageable);

    Optional<LogEvent> findById(Long id);

    LogEvent save(LogEventDTO logEvent);

    void deleteById(Long id);

    List<LogEvent> filterByDescription(String descriptionEvent, Pageable pageable);

    List<LogEvent> filterByLogEvent(String logEvent, Pageable pageable);

    List<LogEvent> filterByOrigin(String origin, Pageable pageable);

    List<LogEvent> filterByDate(String date, Pageable pageable);

    List<LogEvent> filterByQuantity(String quatityByLevel, Pageable pageable);

    List<LogEvent> filterByLevelType(String levelName, Pageable pageable);
}
