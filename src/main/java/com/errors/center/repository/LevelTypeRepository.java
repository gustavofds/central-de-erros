package com.errors.center.repository;

import com.errors.center.model.LevelType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LevelTypeRepository extends CrudRepository<LevelType, Long> {

    @Override
    List<LevelType> findAll();
}
