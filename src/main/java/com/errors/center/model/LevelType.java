package com.errors.center.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "level_type")
public class LevelType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long level_id;

    @Column
    @NotNull
    @Size(max = 65, message = "O nome do level não pode ultrapassar a 65 caracteres!")
    private String level;

    public LevelType() {
    }

    public LevelType(String level) {
        this.level = level;
    }

    public Long getLevel_id() {
        return level_id;
    }

    public void setLevel_id(Long level_id) {
        this.level_id = level_id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
