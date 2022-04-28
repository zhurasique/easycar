package com.service.base.controller;

import com.service.base.entity.Transmission;
import com.service.base.service.TransmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/base-service/transmission")
public class TransmissionController {

    private final TransmissionService transmissionService;

    @GetMapping
    public List<Transmission> findAll() {
        return transmissionService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Transmission transmission) {
        return transmissionService.save(transmission);
    }
}
