package com.service.base.service;

import com.service.base.entity.Engine;
import com.service.base.repository.EngineRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EngineService {

    private final EngineRepo engineRepo;

    public List<Engine> findAll() {
        return engineRepo.findAll();
    }

    public ResponseEntity<?> save(Engine engine) {
        return new ResponseEntity<>(engineRepo.save(engine), HttpStatus.OK);
    }
}
