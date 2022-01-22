package com.errors.center.service;

import com.errors.center.dto.LogEventDTO;
import com.errors.center.model.LevelType;
import com.errors.center.model.LogEvent;
import com.errors.center.repository.LogEventRepository;
import com.errors.center.service.interfaces.LogEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LogEventServiceImpl implements LogEventService {

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
}
