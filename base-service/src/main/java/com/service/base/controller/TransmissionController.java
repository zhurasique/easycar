package com.service.base.controller;

import com.service.base.model.Transmission;
import com.service.base.service.TransmissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/base-service/transmission")
public class TransmissionController {

    private final TransmissionService transmissionService;

    public TransmissionController(TransmissionService transmissionService) {
        this.transmissionService = transmissionService;
    }

    @GetMapping
    public List<Transmission> findAll() {
        return transmissionService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Transmission transmission) {
        return transmissionService.save(transmission);
    }
}
