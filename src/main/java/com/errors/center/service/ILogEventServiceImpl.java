package com.errors.center.service;

import com.errors.center.dto.LogEventDTO;
import com.errors.center.exceptions.NotFoundException;
import com.errors.center.model.LevelType;
import com.errors.center.model.LogEvent;
import com.errors.center.repository.LogEventRepository;
import com.errors.center.service.interfaces.ILogEventService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<LogEvent> findAll() {
        return this.logEventRepository.findAll();
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
    public List<LogEvent> filterByDescription(String descriptionEvent) {
        return this.logEventRepository.findByDescriptionEventContaining(descriptionEvent);
    }

    @Override
    public List<LogEvent> filterByLogEvent(String logEvent) {
        return this.logEventRepository.findByLogEventContaining(logEvent);
    }

    @Override
    public List<LogEvent> filterByOrigin(String origin) {
        return this.logEventRepository.findByOriginContaining(origin);
    }

    @Override
    public List<LogEvent> filterByDate(String date) {
        return this.logEventRepository.findByDate(date);
    }

    @Override
    public List<LogEvent> filterByQuantity(int quantity) {
        return this.logEventRepository.findByQuantityContaining(quantity);
    }

    @Override
    public List<LogEvent> filterByLevelType(String levelName) {
        return this.logEventRepository.findByLevelTypeContaining(levelName);
    }
}
