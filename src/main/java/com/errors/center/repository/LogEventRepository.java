package com.errors.center.repository;

import com.errors.center.model.LevelType;
import com.errors.center.model.LogEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LogEventRepository extends CrudRepository<LogEvent, Long> {
    Page<LogEvent> findAll(Pageable pageable);

    List<LogEvent> findByDescriptionEvent(String descriptionEvent);

    Page<LogEvent> findByDescriptionEventContaining(String descriptionEvent, Pageable pageable);

    Page<LogEvent> findByLogEventContaining(String logEvent, Pageable pageable);

    Page<LogEvent> findByOriginContaining(String origin, Pageable pageable);

    @Query(value = "select * from log_event " +
        "where date = ?1",
        nativeQuery = true
    )
    Page<LogEvent> findByDate(String date, Pageable pageable);

    Page<LogEvent> findByQuantityContaining(int quatity, Pageable pageable);

    Page<LogEvent> findByLevelTypeContaining(String levelName, Pageable pageable);
}
