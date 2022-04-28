package com.service.base.service;

import com.service.base.entity.Color;
import com.service.base.repository.ColorRepo;
import com.service.base.util.ErrorLogUtil;
import com.service.base.util.ValidationUtil;
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

        if(!ValidationUtil.validateColorColor(color.getColor(), colorRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(116), HttpStatus.BAD_REQUEST);

        if(!ValidationUtil.validateColorPattern(color.getPattern(), colorRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(117), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(colorRepo.save(color), HttpStatus.OK);
    }
}
