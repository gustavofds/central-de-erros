package com.errors.center.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_event")
public class LogEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description_event")
    @NotNull
    @Size(max = 255)
    private String descriptionEvent;

    @Column(name = "log_event")
    @NotNull
    @Size(max = 255)
    private String logEvent;

    @Column
    @NotNull
    @Size(max = 100)
    private String origin;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreatedDate
    private LocalDateTime date;

    @Column
    @NotNull
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "level_type")
    private LevelType levelType;

    public LogEvent() {
    }

    public LogEvent(String descriptionEvent, String logEvent, String origin, LocalDateTime date, int quantity, LevelType levelType) {
        this.descriptionEvent = descriptionEvent;
        this.logEvent = logEvent;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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
