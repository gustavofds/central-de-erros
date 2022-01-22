package com.errors.center.service;

import com.errors.center.model.LogEvent;
import com.errors.center.service.interfaces.ILogEventService;
import org.springframework.stereotype.Service;

@Service
public class LogEventService implements ILogEventService {

    @Override
    public LogEvent saveLog(Object log) {
        return null;
    }
}
