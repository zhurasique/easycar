package com.service.base.controller;

import com.service.base.entity.Power;
import com.service.base.service.PowerService;
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
@RequestMapping("api/base-service/power")
public class PowerController {

    private final PowerService powerService;

    @GetMapping
    public List<Power> findAll() {
        return powerService.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Power save(@Valid @RequestBody Power power) {
        return powerService.save(power);
    }
}
