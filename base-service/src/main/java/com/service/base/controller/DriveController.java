package com.service.base.controller;

import com.service.base.model.Drive;
import com.service.base.service.DriveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/base-service/drive")
public class DriveController {

    private final DriveService driveService;

    public DriveController(DriveService driveService) {
        this.driveService = driveService;
    }

    @GetMapping
    public List<Drive> findAll() {
        return driveService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Drive drive) {
        return driveService.save(drive);
    }
}
