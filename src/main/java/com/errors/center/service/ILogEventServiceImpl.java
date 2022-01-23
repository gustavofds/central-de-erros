package com.errors.center.service;

import com.errors.center.dto.LogEventDTO;
import com.errors.center.exceptions.NotFoundException;
import com.errors.center.model.LevelType;
import com.errors.center.model.LogEvent;
import com.errors.center.repository.LogEventRepository;
import com.errors.center.service.interfaces.ILogEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ILogEventServiceImpl implements ILogEventService {

    @Autowired
    private LogEventRepository logEventRepository;

    @Autowired
    private LevelTypeService levelTypeService;

    @Override
    public List<LogEvent> findAll(Pageable pageable) {
        return this.logEventRepository.findAll(pageable).getContent();
    }

    @Override
    public Optional<LogEvent> findById(Long id) {
        return logEventRepository.findById(id);
    }

    @Override
    public LogEvent save(LogEventDTO log) {
        LevelType levelType = levelTypeService.getLevelTypeById(log.getLevelTypeId());
        LocalDateTime date = LocalDateTime.now();

        LogEvent logEvent = new LogEvent();
        logEvent.setDate(date);
        logEvent.setLevelType(levelType);
        logEvent.setDescriptionEvent(log.getDescriptionEvent());
        logEvent.setLogEvent(log.getLogEvent());
        logEvent.setOrigin(log.getOrigin());
        logEvent.setQuantity(log.getQuantity());

        return this.logEventRepository.save(logEvent);
    }

    @Override
    public void deleteById(Long id) {
        this.logEventRepository.deleteById(id);
    }

    @Override
    public List<LogEvent> filterByDescription(String descriptionEvent, Pageable pageable) {
        return this.logEventRepository.findByDescriptionEventContaining(descriptionEvent, pageable).getContent();
    }

    @Override
    public List<LogEvent> filterByLogEvent(String logEvent, Pageable pageable) {
        return this.logEventRepository.findByLogEventContaining(logEvent, pageable).getContent();
    }

    @Override
    public List<LogEvent> filterByOrigin(String origin, Pageable pageable) {
        return this.logEventRepository.findByOriginContaining(origin, pageable).getContent();
    }

    @Override
    public List<LogEvent> filterByDate(String date, Pageable pageable) {
        return this.logEventRepository.findByDate(date, pageable).getContent();
    }

    @Override
    public List<LogEvent> filterByQuantity(int quantity, Pageable pageable) {
        return this.logEventRepository.findByQuantityContaining(quantity, pageable).getContent();
    }

    @Override
    public List<LogEvent> filterByLevelType(String levelName, Pageable pageable) {
        return this.logEventRepository.findByLevelTypeContaining(levelName, pageable).getContent();
    }
}
