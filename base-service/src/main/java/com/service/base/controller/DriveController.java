package com.service.base.controller;

import com.service.base.entity.Drive;
import com.service.base.service.DriveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/base-service/drive")
public class DriveController {

    private final DriveService driveService;

    @GetMapping
    public List<Drive> findAll() {
        return driveService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Drive drive) {
        return driveService.save(drive);
    }
}
