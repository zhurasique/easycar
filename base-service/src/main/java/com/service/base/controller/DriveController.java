package com.service.base.controller;

import com.service.base.entity.Drive;
import com.service.base.service.DriveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
    @ResponseStatus(value = HttpStatus.CREATED)
    public Drive save(@Valid @RequestBody Drive drive) {
        return driveService.save(drive);
    }
}
