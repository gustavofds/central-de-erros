package com.errors.center.repository;

import com.errors.center.model.LogEvent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LogEventRepository extends CrudRepository<LogEvent, Long> {
    List<LogEvent> findAll();

    List<LogEvent> findByDescriptionEvent(String descriptionEvent);

    List<LogEvent> findByDescriptionEventContaining(String descriptionEvent);
}
