package com.service.base.service;

import com.service.base.entity.Drive;
import com.service.base.repository.DriveRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriveService {

    private final DriveRepo driveRepo;

    public List<Drive> findAll() {
        return driveRepo.findAll();
    }

    public Drive save(Drive drive) {
        return driveRepo.save(drive);
    }
}
