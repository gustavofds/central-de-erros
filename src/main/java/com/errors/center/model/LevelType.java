package com.errors.center.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "level_type")
public class LevelType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "level_name")
    @NotNull(message = "O campo level não poder ser nulo!")
    private String levelName;

    public LevelType() {
    }

    public LevelType(String levelName, List<LogEvent> logEventList) {
        this.levelName = levelName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}
