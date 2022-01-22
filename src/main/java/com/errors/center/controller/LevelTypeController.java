package com.errors.center.controller;

import com.errors.center.model.LevelType;
import com.errors.center.service.LevelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class LevelTypeController {

    @Autowired
    private LevelTypeService service;

    @PostMapping("/type")
    ResponseEntity<LevelType> saveLevel(@RequestBody LevelType levelType) {
        LevelType response = service.saveLevel(levelType);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @GetMapping("/type/list")
    ResponseEntity<List<LevelType>> listLevels() {
        List<LevelType> response = service.listLevels();
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @GetMapping("/type/{id}")
    ResponseEntity<LevelType> getLevelTypeById(@PathVariable Long id) {
        LevelType response = service.getLevelTypeById(id);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @PutMapping("/type/{id}")
    ResponseEntity<LevelType> updateLevelType(@PathVariable Long id, @RequestBody LevelType level) {
        LevelType response = service.updateLevelType(id, level.getLevelName());

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @DeleteMapping("/type/{id}")
    ResponseEntity<LevelType> deleteLeveType(@PathVariable Long id) {
        LevelType response = service.deleteLeveType(id);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }
}
