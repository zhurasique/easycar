package com.service.base.service;

import com.service.base.entity.Drive;
import com.service.base.repository.DriveRepo;
import com.service.base.util.ErrorLogUtil;
import com.service.base.util.ValidationUtil;
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

        if(!ValidationUtil.validateDrive(drive.getName(), driveRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(120), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(driveRepo.save(drive), HttpStatus.OK);
    }
}
