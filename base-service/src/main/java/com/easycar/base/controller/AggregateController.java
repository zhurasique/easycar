package com.easycar.base.controller;

import com.easycar.base.service.AggregateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aggregate")
public class AggregateController {

    private AggregateService aggregateService;

    @GetMapping("/brands-regions")
    public ResponseEntity<Map<String, Object>> getBrandsAndRegions() {
        return ResponseEntity.ok(aggregateService.getBrandsAndRegions());
    }
}
