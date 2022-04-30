package com.service.base.controller;

import com.service.base.entity.Transmission;
import com.service.base.service.TransmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("api/base-service/transmission")
public class TransmissionController {

    private final TransmissionService transmissionService;

    @GetMapping
    public List<Transmission> findAll() {
        return transmissionService.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Transmission save(@Valid @RequestBody Transmission transmission) {
        return transmissionService.save(transmission);
    }
}
