package com.errors.center.service;

import com.errors.center.model.LevelType;
import com.errors.center.repository.LevelTypeRepository;
import com.errors.center.service.interfaces.ILevelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelTypeService implements ILevelTypeService {

    @Autowired
    private LevelTypeRepository repository;

    @Override
    public LevelType saveLevel(LevelType levelType) {
        LevelType response = repository.save(levelType);
        return response;
    }

    @Override
    public List<LevelType> listLevels() {
        return repository.findAll();
    }

    @Override
    public LevelType getLevelTypeById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public LevelType updateLevelType(Long id, String levelName) {
        LevelType levelType = repository.findById(id).get();

        levelType.setLevelName(levelName);
        LevelType response = repository.save(levelType);

        return response;
    }

    @Override
    public LevelType deleteLeveType(Long id) {
        LevelType response = repository.findById(id).get();
        repository.deleteById(id);

        return response;
    }
}
