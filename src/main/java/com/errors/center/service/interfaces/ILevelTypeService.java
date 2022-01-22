package com.errors.center.service.interfaces;

import com.errors.center.model.LevelType;

import java.util.List;

public interface ILevelTypeService {

    LevelType saveLevel(LevelType levelType);
    List<LevelType> listLevels();
    LevelType getLevelTypeById(Long id);
    LevelType updateLevelType(Long id, String level);
    LevelType deleteLeveType(Long id);
}
