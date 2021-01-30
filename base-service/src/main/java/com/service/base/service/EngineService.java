package com.service.base.service;

import com.service.base.model.Engine;
import com.service.base.repository.EngineRepo;
import com.service.base.util.ErrorLogUtil;
import com.service.base.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineService {

    private final EngineRepo engineRepo;

    public EngineService(EngineRepo engineRepo) {
        this.engineRepo = engineRepo;
    }

    public List<Engine> findAll() {
        return engineRepo.findAll();
    }

    public ResponseEntity<?> save(Engine engine) {

        if(!ValidationUtil.validateEngineCapacity(engine.getCapacity(), engineRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(114), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(engineRepo.save(engine), HttpStatus.OK);
    }
}
