package com.errors.center.repository;

import com.errors.center.model.LevelType;
import com.errors.center.model.LogEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LogEventRepository extends CrudRepository<LogEvent, Long> {
    Page<LogEvent> findAll(Pageable pageable);

    List<LogEvent> findByDescriptionEvent(String descriptionEvent);

    Page<LogEvent> findByDescriptionEventContaining(String descriptionEvent, Pageable pageable);

    Page<LogEvent> findByLogEventContaining(String logEvent, Pageable pageable);

    Page<LogEvent> findByOriginContaining(String origin, Pageable pageable);

    Page<LogEvent> findByDate(LocalDate date, Pageable pageable);

    @Query(value = "SELECT level_type.level_name, " +
        "COUNT(log_event.quantity) AS quantity " +
        "FROM log_event " +
        "INNER JOIN level_type " +
        "ON log_event.level_type = level_type.id " +
        "WHERE level_type.level_name = :quatityByLevel " +
        "GROUP BY level_type.level_name"
        ,nativeQuery = true)
    Page<LogEvent> findByQuantity(@Param("quatityByLevel") String quatityByLevel, Pageable pageable);

    @Query(value = "SELECT * FROM log_event " +
        "INNER JOIN level_type " +
        "ON log_event.level_type = level_type.id " +
        "WHERE level_type.level_name = :levelName",
        nativeQuery = true)
    Page<LogEvent> findByLevelType(@Param("levelName") String levelName, Pageable pageable);
}
