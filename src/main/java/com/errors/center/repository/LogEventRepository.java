package com.errors.center.repository;

import com.errors.center.model.LevelType;
import com.errors.center.model.LogEvent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LogEventRepository extends CrudRepository<LogEvent, Long> {
    List<LogEvent> findAll();

    List<LogEvent> findByDescriptionEvent(String descriptionEvent);

    List<LogEvent> findByDescriptionEventContaining(String descriptionEvent);

    List<LogEvent> findByLogEventContaining(String logEvent);

    List<LogEvent> findByOriginContaining(String origin);

    @Query(value = "select * from log_event " +
        "where date = ?1",
        nativeQuery = true
    )
    List<LogEvent> findByDate(String date);

    List<LogEvent> findByQuantityContaining(int quatity);

    List<LogEvent> findByLevelTypeContaining(String levelName);
}
