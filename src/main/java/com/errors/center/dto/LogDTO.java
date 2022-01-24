package com.errors.center.dto;

import com.errors.center.model.LevelType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LogDTO {

    private Long id;
    private String descriptionEvent;
    private String origin;
    private LocalDate date;
    private int quantity;
    private LevelType levelType;

    public LogDTO() {
    }

    public LogDTO(Long id, String descriptionEvent, String origin, LocalDate date, int quantity, LevelType levelType) {
        this.id = id;
        this.descriptionEvent = descriptionEvent;
        this.origin = origin;
        this.date = date;
        this.quantity = quantity;
        this.levelType = levelType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescriptionEvent() {
        return descriptionEvent;
    }

    public void setDescriptionEvent(String descriptionEvent) {
        this.descriptionEvent = descriptionEvent;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LevelType getLevelType() {
        return levelType;
    }

    public void setLevelType(LevelType levelType) {
        this.levelType = levelType;
    }
}
