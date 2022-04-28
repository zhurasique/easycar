package com.service.base.service;

import com.service.base.entity.Color;
import com.service.base.repository.ColorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColorService {

    private final ColorRepo colorRepo;

    public List<Color> findAll() {
        return colorRepo.findAll();
    }

    public ResponseEntity<?> save(Color color) {
        return new ResponseEntity<>(colorRepo.save(color), HttpStatus.OK);
    }
}
