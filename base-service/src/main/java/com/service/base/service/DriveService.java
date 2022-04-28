package com.service.base.service;

import com.service.base.entity.Drive;
import com.service.base.repository.DriveRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriveService {

    private final DriveRepo driveRepo;

    public List<Drive> findAll() {
        return driveRepo.findAll();
    }

    public ResponseEntity<?> save(Drive drive) {
        return new ResponseEntity<>(driveRepo.save(drive), HttpStatus.OK);
    }
}
