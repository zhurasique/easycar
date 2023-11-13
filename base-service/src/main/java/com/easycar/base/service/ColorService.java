package com.easycar.base.service;

import com.easycar.common.exception.NoSuchElementFoundException;
import com.easycar.base.entity.Color;
import com.easycar.base.repository.ColorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColorService {

    private final ColorRepo colorRepo;

    public List<Color> findAll() {
        return colorRepo.findAll();
    }

    public Color findById(String id) {
        return colorRepo.findById(id).orElseThrow(() -> new NoSuchElementFoundException(id));
    }

    public Color save(Color color) {
        return colorRepo.save(color);
    }
}
