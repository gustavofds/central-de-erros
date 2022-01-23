package com.errors.center.mapper;

import com.errors.center.dto.LogDTO;
import com.errors.center.model.LogEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LogEventMapper implements ILogEventMapper {
    @Override
    public LogDTO logMap(LogEvent log) {
        if (log == null) {
            return null;
        }

        LogDTO logDTO = new LogDTO();

        logDTO.setDate(log.getDate());
        logDTO.setDescriptionEvent(log.getDescriptionEvent());
        logDTO.setId(log.getId());
        logDTO.setOrigin(log.getOrigin());
        logDTO.setQuantity(log.getQuantity());
        logDTO.setLevelType(log.getLevelType());

        return logDTO;
    }

    @Override
    public List<LogDTO> listMap(List<LogEvent> logs) {
        List<LogDTO> listLogs = new ArrayList<>();

        for (LogEvent log: logs) {
            listLogs.add(logMap(log));
        }

        return listLogs;
    }
}
