package com.errors.center.mapper;

import com.errors.center.dto.LogDTO;
import com.errors.center.model.LogEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ILogEventMapper {

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "descriptionEvent", target = "descriptionEvent"),
        @Mapping(source = "logEvent", target = "logEvent", ignore = true),
        @Mapping(source = "date", target = "date"),
        @Mapping(source = "quantity", target = "quantity"),
        @Mapping(source = "levelType", target = "levelType"),
    })

    LogDTO logMap(LogEvent log);

    List<LogDTO> listMap(List<LogEvent> logs);
}
