package com.errors.center.dto;

import com.errors.center.model.LevelType;
import com.errors.center.model.LogEvent;
import com.errors.center.service.LevelTypeService;
import org.springframework.beans.factory.annotation.Autowired;;

public class LogEventDTO {

    private String descriptionEvent;
    private String logEvent;
    private String origin;
    private int quantity;
    private Long levelTypeId;

    @Autowired
    private LevelTypeService levelTypeService;

    public LogEventDTO(String descriptionEvent, String logEvent, String origin, int quantity, Long levelTypeId) {
        this.descriptionEvent = descriptionEvent;
        this.logEvent = logEvent;
        this.origin = origin;
        this.quantity = quantity;
        this.levelTypeId = levelTypeId;
    }

    public String getDescriptionEvent() {
        return descriptionEvent;
    }

    public void setDescriptionEvent(String descriptionEvent) {
        this.descriptionEvent = descriptionEvent;
    }

    public String getLogEvent() {
        return logEvent;
    }

    public void setLogEvent(String logEvent) {
        this.logEvent = logEvent;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getLevelTypeId() {
        return levelTypeId;
    }

    public void setLevelTypeId(Long levelTypeId) {
        this.levelTypeId = levelTypeId;
    }
}
