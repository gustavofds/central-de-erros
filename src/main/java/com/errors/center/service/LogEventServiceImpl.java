package com.errors.center.service;

import com.errors.center.model.LogEvent;
import com.errors.center.repository.LogEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogEventServiceImpl implements LogEventService {

    @Autowired
    private LogEventRepository logEventRepository;

    @Override
    public List<LogEvent> findAll() {
        return this.logEventRepository.findAll();
    }

    @Override
    public Optional<LogEvent> findById(Long id) {
        return logEventRepository.findById(id);
    }

    @Override
    public LogEvent save(LogEvent logEvent) {
        return this.logEventRepository.save(logEvent);
    }

    @Override
    public void deleteById(Long id) {
        this.logEventRepository.deleteById(id);
    }
}
